package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		
		Dog d1 = new Dog("d1");
		d1.setParent(null);
		
		Dog d2 = new Dog("d2");
		d2.setParent(d1);
		
		Dog d3 = new Dog("d3");
		d3.setParent(d2);
		
		List<Dog> dogs = new ArrayList<Dog>();
		process(dogs, d3);
		for(Dog dog : dogs) {
			System.out.println(dog.getName());
		}
	}
	
	
	public static void process(List<Dog> dogs, Dog now) {
		if(now.getParent() == null) {
			dogs.add(now);
		} else {
			dogs.add(now);
			now = now.getParent();
			process(dogs, now); 
		}
	}

}
