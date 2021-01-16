package com.atguigu.juc;

@FunctionalInterface
//函数式接口，让别人知道用了lambda，不要去扩展这个接口去写其他抽象方法
interface Foo{

    int add(int a, int b);

    default int sub(int a, int b){
        return a-b;
    }

    static int mul(int a, int b){
        return a*b;
    }

}

public class LambdaDemo {

    public static void main(String[] args) {

        Foo foo = (int a, int b) -> a + b;
        int add = foo.add(3, 4);
        System.out.println("add = " + add);

//        ((Foo) (int a, int b) -> {a + b}).add(3,4);

        int add1 = ((Foo) (a, b) -> a + b).add(3, 4);
        System.out.println("add1 = " + add1);

    }

}
