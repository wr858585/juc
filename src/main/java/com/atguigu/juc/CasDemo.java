package com.atguigu.juc;

import java.util.concurrent.atomic.AtomicLong;

public class CasDemo {

    public static void main(String[] args) {

        AtomicLong atomicLong = new AtomicLong(0);
        boolean b = atomicLong.compareAndSet(0, 100);//更新成功，更新后是100
        boolean b2 = atomicLong.compareAndSet(0, 200);//更新失败，值仍然是100
        System.out.println(b);
        System.out.println(atomicLong.get());

    }

}
