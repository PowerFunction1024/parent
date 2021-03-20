package com.jadd.controller.concurrent;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author : Administrator
 * @desc : TODO
 * @date : 2021/3/3
 */
public class TestQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrays = new ArrayBlockingQueue<>(3);
        arrays.add("李四");
        arrays.add("张军");
        arrays.add("张军");
        // 添加阻塞队列
        arrays.offer("张三", 5, TimeUnit.SECONDS);
        System.out.println("主线程--main");
        System.out.println(arrays.toString());
    }

    @Test
    public void fun01(){
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(3);
        linkedBlockingQueue.add("张三");
        linkedBlockingQueue.add("李四");
        linkedBlockingQueue.add("李四");
        System.out.println(linkedBlockingQueue.size());

    }
}
