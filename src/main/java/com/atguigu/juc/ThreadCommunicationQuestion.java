package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题：两个线程打印
 *
 * ​	两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z，要求用线程间通信
 */
class NumsAndLetters{
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    private int flag = 1;
    private int num = 1;
    private char letter = 'A';
//    synchronized public void printNumbers(){
//        try{
//            if(flag != 1){
//                this.wait();
//            }
//            System.out.print(num++);
//            System.out.print(num++);
//            flag = 2;
//            this.notify();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    synchronized public void printLetters(){
//        try{
//            if(flag != 2){
//                this.wait();
//            }
//            System.out.print(letter++);
//            flag = 1;
//            this.notify();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
    public void printNumbers(){
        lock.lock();
        try{
            if(flag != 1){
                condition1.await();
            }
            System.out.print(num++);
            System.out.print(num++);
            flag = 2;
            condition2.signal();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printLetters(){
        lock.lock();
        try{
            if(flag != 2){
                condition2.await();
            }
            System.out.print(letter++);
            flag = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadCommunicationQuestion {

    public static void main(String[] args) {

        NumsAndLetters numsAndLetters = new NumsAndLetters();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                numsAndLetters.printNumbers();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                numsAndLetters.printLetters();
            }
        },"BB").start();

    }

}
