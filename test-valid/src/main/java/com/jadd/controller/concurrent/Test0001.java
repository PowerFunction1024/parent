package com.jadd.controller.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Test0001 implements Runnable {
	private static Integer count = 1;
	private static AtomicInteger atomic = new AtomicInteger();
	@Override
	public void run() {
		while (true) {
			//int count = getCount();
			int count = getCountAtomic();
			System.out.println("thread-->"+ Thread.currentThread().getName()+"  coutnt--->"+count);
			if (count >= 150) {
				break;
			}
		}
	}
	public synchronized Integer getCount() {
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count++;
	}
	public Integer getCountAtomic() {
		try {
			Thread.sleep(50);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return atomic.incrementAndGet();
	}
	public static void main(String[] args) {
		Test0001 test0001 = new Test0001();
		Thread t1 = new Thread(test0001);
		Thread t2 = new Thread(test0001);
		t1.start();
		t2.start();
		System.out.println("主线程main");
	}
}