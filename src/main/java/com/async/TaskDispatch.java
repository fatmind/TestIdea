package com.async;

import java.util.ArrayList;
import java.util.List;


public class TaskDispatch<T> {

	/*
	 * ÈÎÎñ»º³åÇø
	 */
	private final List<T> buffer = new ArrayList<T>(256);
	
	public static final int DEFAULT_BUFFER_SIZE = 6;

	public void addTask(T task) {
		synchronized (buffer) {
			try {
				if(buffer.size() >= DEFAULT_BUFFER_SIZE) {
					buffer.notifyAll();
					buffer.wait();
					System.out.println("----------"); 
					buffer.add(task);
				} else {
					buffer.add(task);
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public List<T> getBuffer() {
		return buffer;
	}
	public static int getDEFAULT_BUFFER_SIZE() {
		return DEFAULT_BUFFER_SIZE;
	}

	
}
