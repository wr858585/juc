package com.atguigu.juc;

public class VolatileDemo2 {

    private static Integer a, b;
    private static Integer x, y;

    public static void main(String[] args) throws InterruptedException {

        int number = 0;
        while(true){
            number++;
            a=b=x=y=0;
            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println("第" + number + "x = " + x + ", y =" + y );
            if(x == 0 && y == 0){   //此时出现了指令重排
                return;
            }

        }

    }

}
