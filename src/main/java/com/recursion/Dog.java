package com.recursion;

public class Dog {
	
	private Dog parent;
	
	private String name;
	
	public Dog(String name) {
		this.name = name;
	}

	public Dog getParent() {
		return parent;
	}

	public void setParent(Dog parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
