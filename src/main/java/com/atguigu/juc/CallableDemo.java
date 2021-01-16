package com.atguigu.juc;

        import java.util.concurrent.Callable;
        import java.util.concurrent.FutureTask;

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "这里通过实现Callable接口，实现了多线程程序！");
        return "hello callable";
    }
}

public class CallableDemo {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        new Thread(futureTask).start();
        try {
            //get方法会阻塞主线程，直到子任务结束，返回结果集，才能get到
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("这是main方法线程");

    }

}
