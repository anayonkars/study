package code.demoutils.BitCoin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

class NonceFinder implements Callable<Long> {

	private StringBuilder input;
	@SuppressWarnings("unused")
	private int prefixZero;
	private long start;
	private long end;
	private long thisTaskId;
	private static AtomicLong taskId = new AtomicLong(0);
	private MessageDigest md;
	private static final StringBuilder comparatingString = new StringBuilder();
	public static void initComparingString(int prefixZero)
	{
		for(int i = 0 ; i < prefixZero ; i++)
		{
			comparatingString.append("0");
		}
	}
	//private static volatile boolean isRunning = true;
	public NonceFinder(StringBuilder input, int prefixZero, long start, long end) throws NoSuchAlgorithmException
	{
		this.input = input;
		this.prefixZero = prefixZero;
		this.start = start;
		this.end = end;
		this.thisTaskId = taskId.incrementAndGet();
		this.md = MessageDigest.getInstance("SHA-256");
	}
	
	public Long call() throws Exception {
		String originalInput = input.toString();
		String result;
		long count;
		for(count = start ; count < end ; count++)
		{
			String inputForHash = originalInput + count;
			md.update(inputForHash.getBytes());
			result = convertHash(md.digest());
			/*if(count.mod(million).equals(zero))
			{
				System.out.println(count.divide(million));
			}*/
			//System.out.println(result);
			if(result.toString().startsWith(comparatingString.toString()))
			{
				System.out.println("input: " + inputForHash);
				System.out.println("result: " + result);
				System.out.println("nonce: " + count);
				long stopTime = System.nanoTime();
				System.out.println("Time taken: " + (stopTime - SHAMain.startTime) / 1000000);
				//System.exit(0);
				return count;
			}
		}
		//if(isRunning)
		System.out.println("No nonce found for range " + start/SHAMain.CHECKS_PER_TASK + " - " + end/SHAMain.CHECKS_PER_TASK);
		return null;
	}

	@Override
	public int hashCode() {
		return taskId.intValue();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj != null && obj instanceof NonceFinder && ((NonceFinder)obj).getThisTaskId() == thisTaskId);
	}

	public long getThisTaskId() {
		return thisTaskId;
	}
	
	private String convertHash(byte[] hash)	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < hash.length ; i++)
		{
			String hex = Integer.toHexString(0xFF & hash[i]);
			if(hex.length() == 1)
			{
				sb.append('0');
			}
			sb.append(hex);
		}
		return sb.toString();
	}
}
