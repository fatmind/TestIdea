package com.collection;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapBalanceTest {

	
	public static void main(String[] args) {
		
		TreeMap<Dog, String> dogs = new TreeMap<Dog, String>();
		Dog d1 = new Dog(1);
		Dog d2 = new Dog(2);
		Dog d3 = new Dog(3);
		
		String value = "GoodDog";
		dogs.put(d1, value);
		dogs.put(d2, value);
		dogs.put(d3, value);
		
		System.out.println(dogs.firstKey().getAge());
		
		if(dogs.containsKey(d1)) {
			System.out.println("Success ...");
		}
		
		Iterator<Entry<Dog, String>> dogIterator = dogs.entrySet().iterator();
		while(dogIterator.hasNext()) {
			System.out.println(dogIterator.next().getKey().getAge());
		}
		
		
	}
	
	
}




class Dog implements Comparable<Dog> {
	
	private int age;
	
	public Dog(int age) {
		this.age = age;
	}
	
	public int compareTo(Dog t) {
		if(this.age > t.age) {
			return 1;
		} else if (this.age < t.age){
			return -1;
		} else {
			return 0;
		}
	}

	public int getAge() {
		return age;
	}
	
	

	
	
}

