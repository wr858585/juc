package com.atguigu.juc;

import java.util.concurrent.CountDownLatch;

class DataOne{
    public int number = 0;
    public void incr(){
        number++;
    }
}

public class VolatileDemo3 {

    public static void main(String[] args) throws InterruptedException {

        DataOne dataOne = new DataOne();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                dataOne.incr();
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(dataOne.number);
    }
}
