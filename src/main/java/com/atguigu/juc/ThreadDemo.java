package com.atguigu.juc;

public class ThreadDemo {

    public static void main(String[] args) {

        //方式一a：继承Thread类
        new MyThread().start();//start开启线程Thread-0，会去执行run方法，所以会打印
        System.out.println("这是main方法线程：" + Thread.currentThread().getName());

        //方式一b：继承Thead类，使用匿名内部类
        new Thread(new MyThread(), "Thread-1").start();//start开启线程Thread-1，会去执行run方法，所以会打印
        System.out.println("这里还是main方法线程：" + Thread.currentThread().getName());

        //方式二a：实现Runnable接口
        new Thread(new MyRunnable(),"Thread-2").start();

        //方式二b：实现Runnable接口，使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是通过实现Runnable接口，匿名内部类方式实现了多线程：" + Thread.currentThread().getName());
            }
        },"Thread-3").start();

        //方式二c：实现Runnable接口，使用λ表达式
        new Thread(()->{
            System.out.println("这是通过实现Runnable接口，lambda表达式实现了多线程：" + Thread.currentThread().getName());
        }, "Thread-4").start();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("这里通过继承Thread类实现了多线程程序：" + Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("这是通过实现Runnable接口实现了多线程程序：" + Thread.currentThread().getName());
    }
}
