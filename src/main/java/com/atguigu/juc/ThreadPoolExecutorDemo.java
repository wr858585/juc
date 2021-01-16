package com.atguigu.juc;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            threadPoolExecutor.submit(()->{
                System.out.println(Thread.currentThread().getName() + "：执行了任务" + finalI);
            });
        }

        }

        //固定大小的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //无线大小的线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
        //单个大小的线程池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //定时任务的线程池
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
//        System.out.println("定时任务初始化时间："  + System.currentTimeMillis());
////        executorService.schedule(()->{
////            System.out.println(Thread.currentThread().getName() + "定时任务执行了" + System.currentTimeMillis());
////        },10, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(()->{
//            System.out.println(Thread.currentThread().getName() + "定时任务执行了" + System.currentTimeMillis());
//        },5,10, TimeUnit.SECONDS);
//        for (int i = 0; i < 100; i++) {
//            executorService.execute(()->{
//                System.out.println(Thread.currentThread().getName() + "执行了任务");
//            });
//        }
//        executorService.shutdown();
//
//    }

}
