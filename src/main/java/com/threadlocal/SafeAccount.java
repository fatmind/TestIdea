package com.threadlocal;

public class SafeAccount implements Account {

	
	private ThreadLocal<Double> money = new ThreadLocal<Double>();
	
	public void save(double m) {
		Double oldValue = money.get();
		if(oldValue == null) 
			oldValue = 0.0;
		money.set(oldValue + m);
	}

	public double getMoney() {
		return money.get();
	}
	
}
