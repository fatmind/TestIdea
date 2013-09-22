package com.classloader;



public class TestPrintClassLoader {
	
	public static void main(String[] args) {
		
		ClassLoader cl = TestPrintClassLoader.class.getClassLoader();
		
		System.out.println(cl);
		System.out.println(cl.getParent());
		System.out.println(cl.getParent().getParent());
		
//		System.out.println(String.class.getClassLoader());
		
		System.out.println(Thread.currentThread().getContextClassLoader());
		

		
//	    URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs(); 
//	    for (int i = 0; i < urls.length; i++) { 
//	      System.out.println(urls[i].toExternalForm()); 
//	    } 
		
//		TestPrintClassLoader.class.getResourceAsStream("");
//		TestPrintClassLoader.class.getClassLoader().getResourceAsStream("");
		
	}

}
