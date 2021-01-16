package com.atguigu.juc;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class VolatileDemo {

    private static volatile Integer number = 1;//volatile保证了可见性

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            System.out.println("子线程读取的number初始值：" + number);
            while(number == 1){
                //不能做操作，否则跟主线程进行交互了，会读到最新值，证明不了这里没有可见性
            }
            System.out.println("子线程读取的number最新值：" + number);
        }).start();

        System.out.println("主线程读取的number初始值：" + number);

        TimeUnit.SECONDS.sleep(2);
        number = 2;

        System.out.println("主线程已经把number的值改为：" + number);


    }

}
