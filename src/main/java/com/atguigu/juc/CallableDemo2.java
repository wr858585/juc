package com.atguigu.juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTask = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                return Thread.currentThread().getName() + "用Callable的方式创建了多线程程序";
            }
        });

        new Thread(futureTask).start();

        System.out.println(futureTask.get());   //这个会阻塞当前线程（main），直到get方法得到了结果

        System.out.println(Thread.currentThread().getName() + "hello callable from main ：）");

    }

}
