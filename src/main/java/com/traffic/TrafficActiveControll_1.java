package com.traffic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TrafficActiveControll_1 {

	static int MAX_QPS = 20;
	static Semaphore counter;

	public static void handleMessage(int j) {
		counter.acquireUninterruptibly(1);
		log(j);
	}

	static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SSSS");
	static void log(int x) {
		System.out.println(format.format(new Date()) + "-" + Thread.currentThread() + ":" + x);
	}

	public static void main(String... args) throws Exception {
		
		Thread.sleep(1000 * 5);
		
		int concurrentLevel = 16;
		
		counter = new Semaphore(MAX_QPS, true);
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				int permit = (MAX_QPS/2) - counter.availablePermits();
				if(permit > 0) 
					counter.release(permit);
			}
		}, 200, 100, TimeUnit.MILLISECONDS);
		
		ExecutorService pool = Executors.newFixedThreadPool(concurrentLevel);
		for (int i = 0; i < concurrentLevel; i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 1; j < 1000; j++)
						handleMessage(j);
				}
			});
		}
		pool.shutdown();
		System.err.println("Done");
	}

}
