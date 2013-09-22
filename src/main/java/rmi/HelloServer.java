package rmi;

import java.rmi.Naming;

public class HelloServer {

	/**
	 * ���� RMI ע����񲢽��ж���ע��
	 */
	public static void main(String[] argv) {
		try {

			Hello hello = new HelloImp("xiaopang");
			Naming.rebind("Hello", hello);

			System.out.println("rmi Server is ready ...");
			
		} catch (Exception e) {
			System.out.println("rmi Server is failed . " + e);
		}
	}

}
