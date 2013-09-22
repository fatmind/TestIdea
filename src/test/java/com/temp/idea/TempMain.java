package com.temp.idea;

import java.util.ArrayList;
import java.util.List;

public class TempMain {

	volatile static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
	      
	      list.add("1");
	      list.add("2");
	      list.add("3");
	      list.add("4");
	      
	      list.iterator();

	      new Thread(new Runnable(){
	         public void run(){
	            try {
	               Thread.sleep(2000L);
	               list = new ArrayList<String>();
	               System.out.println(Thread.currentThread().getName() + " - " + System.currentTimeMillis() + " - " + "list reset");
	            } catch (InterruptedException e) {
	            	e.printStackTrace();
	            }
	         }
	      }).start();
	      
	      
	      for(String s : list){
	         try {
	            Thread.sleep(1000L);
	            System.out.println(Thread.currentThread().getName() + " - " + System.currentTimeMillis() + " - " + s);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	      }   
	   }
}
