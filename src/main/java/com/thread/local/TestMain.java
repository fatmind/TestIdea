package com.thread.local;

import java.util.Random;


public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
//		for(int i=0; i<10; i++) {
//			Cat cat = new Cat("==" + i);
//			Thread t = new Thread(cat);
//			t.start();
//		}
		
//		final int HASH_INCREMENT = 0x61c88647;
//		AtomicInteger nextHashcode = new AtomicInteger();
//		int count = 0;
//		int[] resp = new int[10];
//		while(count < 10) {
//			System.out.println(nextHashcode.getAndAdd(HASH_INCREMENT) & (resp.length - 1));
//			count++;
//		}
		
		/**
		 * threadLocalHashCode = nextHashCode()每次计算，都是新值？为什么可以命中
		 */
		ThreadLocal<String> cache = new ThreadLocal<String>();
		cache.set("xiaopang");
		System.out.println(cache.get());
		
	
	}
	
	

}


class Cat implements Runnable {
	
	private String name;
	public Cat(String name) {
		this.name = name;
	}
	
	public void run() {
		Store store = Store.getInstance();
		Dog dog = new Dog(name);
		store.local.set(dog);
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(store.local.get().name);
	}
	
	
}