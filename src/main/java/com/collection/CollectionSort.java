package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CollectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CollectionSort main = new CollectionSort();
		
		List<Dog> dogs = new ArrayList<Dog>();
		Random random = new Random();
		for(int i=0; i<10; i++) {
			Dog dog = main.new Dog();
			dog.setAge("" + random.nextInt(100));
			dogs.add(dog);
		}
		
		Collections.sort(dogs, new Comparator<Dog>() {

			public int compare(Dog o1, Dog o2) {
				int c1 = Integer.parseInt(o1.getAge());
				int c2 = Integer.parseInt(o2.getAge());
				if(c1 > c2) {
					return 1;
				} else if(c1 == c2){
					return 0;
				} else
					return -1;
				}
		});
		
		
		System.out.println("--------------");
		
	}
	
	
	class Dog {
		private String age;

		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}	
	}

}
