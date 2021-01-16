package com.atguigu.juc;

import java.util.HashMap;
import java.util.Map;

class MyCache{
    private Map<String, Object> cache = new HashMap<>();
    public void put(String key, Object value) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "写缓存开始......");
        Thread.sleep(200);
        cache.put(key,value);
        System.out.println(Thread.currentThread().getName() + "写缓存结束......=================");
    }
    public void get(String key) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "读缓存开始......");
        Thread.sleep(200);
        cache.get(key);
        System.out.println(Thread.currentThread().getName() + "读缓存结束......+++++++++++++++++");
    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();



    }

}
