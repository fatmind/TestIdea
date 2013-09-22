package com.base;

import java.util.concurrent.atomic.AtomicInteger;

public class TestFinal {

	private static AtomicInteger nextHashCode = new AtomicInteger();
	private static final int HASH_INCREMENT = 0x61c88647;
	private final int threadLocalHashCode = nextHashCode();

	private static int nextHashCode() {
		return nextHashCode.getAndAdd(HASH_INCREMENT);
	}

	
	
	public static void main(String[] args) {
		TestFinal testFinal = new TestFinal();
		for(int i=0; i<5; i++) {
			System.out.println(testFinal.threadLocalHashCode);	
		}
	}

}
