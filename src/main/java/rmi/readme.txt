
1.创建接口，必须集成Remote接口

public interface Hello extends Remote {
	public String disName() throws RemoteException ;
}

2.实现接口（UnicastRemoteObject作用未知？）

public class HelloImp extends UnicastRemoteObject implements Hello {

	private String name;
	public HelloImp(String name) throws RemoteException {
		this.name = name;
	}
	
	public String disName() throws RemoteException {
		System.out.println("this is name : " + name);
		return name;
	}
	
}

3.编译Hello和HelloImp，生成 stub
【rmic HelloImp】 --> HelloImp_Stub.java

4.开启 rmiregistry 服务 ：【rmiregistry】

5.编写HelloServer，目的：注册Hello到rmiregistry

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

6.运行HelloServer ：java HelloServer

常见问题：rmi说找不到stub
原因：rmiregistry找不到stub，而不是java com.Server找不到stub
解决方法：在stub的类同一个目录下启动rmiregistry

7.编写客户端，运行客户端
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

8.输出：客户端“xiaopang”，服务器端“this is name : xiaopang”

