package com.atguigu.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotSafeDemo {

    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>(new ArrayList<>());

        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println("list = " + list);
            },"").start();
        }
    }

}
