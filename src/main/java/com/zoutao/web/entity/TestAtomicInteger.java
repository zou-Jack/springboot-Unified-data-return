package com.zoutao.web.entity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 通过多次运行测试，可以看到只有AtomicInteger能够真正保证最终结果永远是2000。
 * @Author: Zoutao
 * @Date: 2020/4/15
 */
public class TestAtomicInteger {
    private static final int THREADS_COUNT = 2;  //线程数

    public static int count = 0;                // 传统变量
    public static volatile int countVolatile = 0; // volatile标识为并发变量
    public static AtomicInteger atomicInteger = new AtomicInteger(0); // AtomicInteger变量
    public static CountDownLatch countDownLatch = new CountDownLatch(2); //countDownLatch是一个计数器，线程完成一个记录一个，递减，只能用一次

    public static void increase() {
        count++;
        countVolatile++;
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        System.out.println("主线程开始执行…… ……");
        for(int i = 0; i< threads.length; i++) {
            threads[i] = new Thread(() -> {
                for(int i1 = 0; i1 < 1000; i1++) {
                    increase();  //调用递增方法
                }

                /*** 每次减少一个容量*/
                countDownLatch.countDown();
                System.out.println("thread counts = " + (countDownLatch.getCount()));//线程计数
            });
            threads[i].start();
        }

        countDownLatch.await();
        System.out.println("concurrency counts = " + (100 - countDownLatch.getCount())); //并发计数
        System.out.println(count);
        System.out.println(countVolatile);
        System.out.println(atomicInteger.get());
    }
}