package com.thread;

import java.sql.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Thread2());
        executorService.submit(new Thread1());
    }

}

class Thread1 implements Runnable {

	public void run() {
        Date date = null;
        try {
            System.out.println(date.getTime());
        }catch(NullPointerException e) {
            e.printStackTrace();
        }
	}



}

class Thread2 implements Runnable {

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread2 is run success."); 
    }

}
