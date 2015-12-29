package code.demoutils.BitCoin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class SHAMain {

	private static final int THREAD_COUNT = 8;
	private static final int WAIT_FACTOR = 10;
	public static final long CHECKS_PER_TASK = 1000000;
	public static MessageDigest md = null;
	public static final long startTime = System.nanoTime();
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		findNonce(new StringBuilder("Hello, World!"), 5);
	}
	
	public static void findNonce(final StringBuilder input, final int prefixZero) throws NoSuchAlgorithmException {
		md = MessageDigest.getInstance("SHA-256");
		NonceFinder.initComparingString(prefixZero);
		final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
		final ExecutorCompletionService<Long> executorCompletionService = new ExecutorCompletionService<>(executorService);
		final List<Future<Long>> resultList = new ArrayList<Future<Long>>();
		Runnable submitter = new Runnable()
		{
			@Override
			public void run()
			{
				long count = 0;
				do
				{
					long start = count * CHECKS_PER_TASK;
					count++;
					long end = count * CHECKS_PER_TASK;
					try
					{
						Callable<Long> task = new NonceFinder(input, prefixZero, start, end);
						synchronized (resultList)
						{
							while(resultList.size() > (THREAD_COUNT * WAIT_FACTOR)
									&& !executorService.isTerminated() 
									&& !executorService.isShutdown())
							{
								System.out.println("Waiting as resultList size is " + resultList.size());
								resultList.wait();
							}
							Future<Long> result = executorCompletionService.submit(task);
							resultList.add(result);
							resultList.notifyAll();
						}
						//Thread.sleep(1000);
					}
					catch (NoSuchAlgorithmException | InterruptedException e)
					{
						e.printStackTrace();
					}
					catch(RejectedExecutionException e) {
						//TODO: how to handle?
					}
				}while(!executorService.isTerminated() && !executorService.isShutdown());
			}
		};
		Runnable retriever = new Runnable()
		{
			
			@Override
			public void run()
			{
				while(true)
				{
					synchronized (resultList)
					{
						while(resultList.isEmpty())
						{
							try
							{
								resultList.wait();
							}
							catch (InterruptedException e)
							{
								e.printStackTrace();
							}
						}
					}
					Future<Long> result;
					synchronized (resultList)
					{
						result = resultList.remove(0);
						if(resultList.size() < THREAD_COUNT)
						{
							System.out.println("resuming as resultList size is " + resultList.size());
							resultList.notifyAll();
						}
					}
					Long nonce = null;
					try
					{
						nonce = result.get();
					}
					catch (InterruptedException | ExecutionException e)
					{
						e.printStackTrace();
					}
					if(nonce != null)
					{
						System.out.println(nonce);
						@SuppressWarnings("unused")
						long stopTime = System.nanoTime();
						System.out.println("Time taken: " + (stopTime - startTime) / 1000000);
						@SuppressWarnings("unused")
						List<Runnable> pendingTasks = executorService.shutdownNow();
						//NonceFinder.setRunning(false);
					}
					if(executorService.isShutdown() || executorService.isTerminated()) {
						synchronized (resultList) {
							resultList.notifyAll();
						}
						break;
					}
				}
			}
		};
		Thread submitterThread = new Thread(submitter);
		Thread retrieverThread = new Thread(retriever);
		submitterThread.start();
		retrieverThread.start();
	}

}
