package com.atguigu.juc;

import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int number = 20;
    private ReentrantLock lock = new ReentrantLock(true);
    public void sell(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "：开始出票");
        try {
            if(number <= 0){
                System.out.println("余票不足");
                return;
            }
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(Thread.currentThread().getName() + "：出票成功" + --number);
    }
}

public class SellTicket {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sell();
            }
        }, "AAA").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sell();
            }
        },"BBB").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ticket.sell();
            }
        },"CCC").start();

    }

}
