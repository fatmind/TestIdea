package com.threadlocal;

public class CommonAccount implements Account {
	
	private double money;
	
	public void save(double m) {
		this.money = this.money + m;
	}

	public double getMoney() {
		return money;
	}
	
	

}
