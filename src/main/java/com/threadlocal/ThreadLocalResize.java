package com.threadlocal;

public class ThreadLocalResize {

	public static void main(String[] args) {
		
		String value = "xiaopang";
		
		for(int i=0; i<17; i++) {
			
			ThreadLocal<String> t = new ThreadLocal<String>();
			
			if(i == 10) {
				t.set(value);
			}
			
			t.set(value);
			
		}
		
	}

}
