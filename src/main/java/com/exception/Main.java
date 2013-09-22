package com.exception;

import java.io.IOException;

public class Main {
	
	
	public static void main(String[] args) {
//		try {
//			new Main().testMethod();
//		} catch(DaoException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//new Main().testThrowsRuntimeException();
	    
	    try {
	        StringUtil util = new StringUtil();
	        util.formatNum("shi");
	    } catch(ProviderException e) {
	        System.out.println("ProviderException"); 
	    } catch(Exception e) {
	        System.out.println("Exception"); 
	    }
	    
	}
	  
	public void testMethod() throws IOException {
		throw new DaoException();
	}
	
	public void testThrowsRuntimeException() throws RuntimeException {
		try {
			Math math = null;
			math.toString();
		} catch(NullPointerException e) {
			System.out.println(e.getClass().getName()); 
		}
		
		
	}

}
