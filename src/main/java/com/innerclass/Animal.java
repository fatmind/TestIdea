package com.innerclass;

public class Animal {
	
	private String name;
	private Dog dog;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	public Dog getDog() {
		return this.dog;
	}



	public class Dog {
		private int price;

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		
	}

	
}
