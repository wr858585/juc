package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ShareDataTwo{
    ReentrantLock lock = new ReentrantLock();
    private Integer flag = 1; // 线程标识位，通过它区分线程切换
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public void print5A(){
        lock.lock();
            try {
                if(flag != 1) {
                    condition1.await();
                }
                System.out.println("AAAAA");
                flag = 2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    public void print10B(){
        lock.lock();
        try {
            if(flag != 2) {
                condition2.await();
            }
            System.out.println("BBBBBBBBBB");
            flag = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15C(){
        lock.lock();
        try{
            if(flag != 3){
                condition3.await();
            }
            System.out.println("CCCCCCCCCCCCCCC");
            flag = 1;
            condition1.signal();
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadOrderDemo {

    public static void main(String[] args) {

        ShareDataTwo dataTwo = new ShareDataTwo();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                dataTwo.print5A();
            }
        },"AAA" ).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                dataTwo.print10B();
            }
        },"BBB" ).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                dataTwo.print15C();
            }
        },"CCC" ).start();

    }

}
