package rmi;

import java.rmi.Naming;

public class HelloServer {

	/**
	 * 启动 RMI 注册服务并进行对象注册
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
