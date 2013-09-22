package com.classloader.baz;


public class Baz {
	
	public Baz() {
		
	}
	
	public void print(String a, String b) {
		System.out.println("Baz classloader : " + Baz.class.getClassLoader());
		System.out.println("Baz --> " + a + " " + b);
	}

}
