package com.atguigu.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {

    public Integer number;

    public UnsafeDemo(Integer number) {
        this.number = number;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        UnsafeDemo unsafeDemo = new UnsafeDemo(10);
        System.out.println("unsafeDemo.number = " + unsafeDemo.number);

//        Unsafe unsafe = Unsafe.getUnsafe(); SecurityException: Unsafe，底层有@CallerSensitive，只能JDK自己调用
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);
        System.out.println("unsafe = " + unsafe);

        long numberOffset = unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("number"));
        unsafe.compareAndSwapObject(unsafeDemo,numberOffset,10,100);
        System.out.println("unsafeDemo.number = " + unsafeDemo.number);

    }

}
