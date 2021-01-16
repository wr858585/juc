package com.atguigu.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.put("d"); //队列已满，会阻塞线程

        /*
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d")); //null
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.peek());   //null
         */

        /*
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d")); //java.lang.IllegalStateException: Queue full
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove()); //FIFO --> a
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove()); //FIFO --> b
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove()); //FIFO --> c
//        System.out.println(blockingQueue.element()); //已经没有元素了，所以报错NoSuchElementException
//        System.out.println(blockingQueue.remove()); //java.util.NoSuchElementException
         */
    }

}
