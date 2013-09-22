package com.thread;

public class TestMain1 {

	
	public static void main(String[] args) {
		Power power = new Power();
		power.off();
		ProcessUnit p1 = new ProcessUnit("p1", power);
		ProcessUnit p2 = new ProcessUnit("p2", power);
		ProcessUnit p3 = new ProcessUnit("p3", power);
		ProcessUnit p4 = new ProcessUnit("p4", power);
		//p2.waitFor(p1);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		power.on();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//p3.pause(1000);

	}

}




