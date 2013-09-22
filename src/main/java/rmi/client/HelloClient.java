package rmi.client;

import java.rmi.Naming;

import rmi.Hello;

public class HelloClient {

	/**
	 * 查找远程对象并调用远程方法
	 */
	public static void main(String[] argv) {
		try {
			Hello hello = (Hello) Naming.lookup("Hello");
			System.out.println(hello.disName());
			
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e);
		}
	}

}
