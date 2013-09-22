package com.thread;

public class ProcessUnit extends Thread {
	
	private String name;
	private Power power;
	
	public ProcessUnit(String name, Power power) {
		super(power, name);
	}

}
