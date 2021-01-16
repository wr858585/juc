package com.atguigu.juc;

class ShareDataOne{
    private int number = 0;
    synchronized public void incr() throws InterruptedException {
        //1. 判断
        if(number != 0){
            this.wait();
        }
        //2. 干活
        number++;
        System.out.println(Thread.currentThread().getName() + "：" + number);
        //3. 通知
        this.notifyAll();
    }
    synchronized public void decr() throws InterruptedException {
        //1. 判断
        if(number != 1){
            this.wait();
        }
        //2. 干活
        number--;
        System.out.println(Thread.currentThread().getName() + "：" + number);
        //3. 通知
        this.notifyAll();
    }
}

public class WaitNotifyDemo {
    public static void main(String[] args) {
        ShareDataOne shareDataOne = new ShareDataOne();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareDataOne.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    shareDataOne.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();



    }
}
