package com.thread.local;

public class Store {
	
	public ThreadLocal<Dog> local = new ThreadLocal<Dog>();
	
	public static Store instance = new Store();
	
	private Store() {
		
	}
	
	public static Store getInstance() {
		return instance;
	}

}

class Dog {
	public String name;
	
	public Dog() {
		
	}
	
	public Dog(String name) {
		this.name = name;
	}
	
}
