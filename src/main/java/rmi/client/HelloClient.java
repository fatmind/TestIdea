package rmi.client;

import java.rmi.Naming;

import rmi.Hello;

public class HelloClient {

	/**
	 * ����Զ�̶��󲢵���Զ�̷���
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
