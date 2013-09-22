package com.traffic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class TrafficActiveControll_2 {

	static long startTime = System.currentTimeMillis();
	static long intervalTime = 100; //maxQps=100/s
	static int qpsThreshold = 10;
	static AtomicLong counter = new AtomicLong(0);

	public static void handleMessage(int i) {
		if (counter.incrementAndGet() > qpsThreshold) {
			synchronized (counter) {
				long diffTime = System.currentTimeMillis() - startTime;
				if (diffTime < intervalTime) {
					try {
						Thread.sleep(intervalTime - diffTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				startTime = System.currentTimeMillis();
				counter.set(0);
			}
		}
		log(i);
	}
	
	static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss:SSSS");
	static void log(int x) {
		System.out.println(format.format(new Date()) + "-" + Thread.currentThread() + ":" + x);
	}
	
	public static void main(String... args) throws Exception {
		
		//Thread.sleep(1000 * 5);
		
		int concurrentLevel = 16;
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
