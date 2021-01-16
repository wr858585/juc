package com.atguigu.juc;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, ()->{
            System.out.println(Thread.currentThread().getName() + "号玩家过关，恭喜所有玩家都过关了！");
        });

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + " is on Stage 1...");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "通过第1关了");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " is on Stage 2...");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "通过第2关了");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " is on Stage 3...");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "通过第3关了");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " is on Stage 4...");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "通过第4关了");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }

}
