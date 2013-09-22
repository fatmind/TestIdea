package com.innerclass;

import com.innerclass.Animal.Dog;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Animal animal = new Animal();
		Dog d = animal.new Dog();
		Dog dog = animal.getDog();
		dog.getPrice();
		
	}
	
	public static void createDog(Animal animal) {
		Dog dog = animal.new Dog();
	}

}
