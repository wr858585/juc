package com.atguigu.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "同学要出门了......");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "同学已经出门了！！！！！！");
                    latch.countDown();
                    //该方法位置可以灵活，每次调用数值-1，减为0时，放行被await的线程（这里就是main线程）
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        latch.await();

        System.out.println("班长锁门了");
    }

}
