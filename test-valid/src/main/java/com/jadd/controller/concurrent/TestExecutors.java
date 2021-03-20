package com.jadd.controller.concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author : Administrator
 * @desc : TODO
 * @date : 2021/3/4
 */
public class TestExecutors {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        for (int i = 1; i <= 6; i++) {
            TaskThred t1 = new TaskThred("任务" + i);
            executor.execute(t1);
        }
        executor.shutdown();
    }
}

class TaskThred implements Runnable {
    private String taskName;

    public TaskThred(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + taskName);
    }
}

