package code.demoutils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
public class TransferQueueDemo {
    private static LinkedTransferQueue<Integer> linkedTransferQueue = new LinkedTransferQueue<>();
    private Runnable producer = () -> {
        for(int i = 0 ; i < 3 ; i++) {
            try {
                System.out.println("Producer is transferring");
                linkedTransferQueue.transfer(i);
                //linkedTransferQueue.offer(i);
                System.out.println("Producer has transferred");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable consumer = () -> {
        for(int i = 0 ; i < 3 ; i++) {
            try {
                System.out.println("Consumer is waiting");
                Integer x = linkedTransferQueue.take();
                System.out.println("Consumer got " + x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        TransferQueueDemo td = new TransferQueueDemo();
        es.execute(td.getProducer());
        es.execute(td.getConsumer());
        es.shutdown();
    }

    public Runnable getProducer() {
        return producer;
    }

    public Runnable getConsumer() {
        return consumer;
    }
}
