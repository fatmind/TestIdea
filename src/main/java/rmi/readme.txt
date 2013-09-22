
1.�����ӿڣ����뼯��Remote�ӿ�

public interface Hello extends Remote {
	public String disName() throws RemoteException ;
}

2.ʵ�ֽӿڣ�UnicastRemoteObject����δ֪����

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

3.����Hello��HelloImp������ stub
��rmic HelloImp�� --> HelloImp_Stub.java

4.���� rmiregistry ���� ����rmiregistry��

5.��дHelloServer��Ŀ�ģ�ע��Hello��rmiregistry

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

6.����HelloServer ��java HelloServer

�������⣺rmi˵�Ҳ���stub
ԭ��rmiregistry�Ҳ���stub��������java com.Server�Ҳ���stub
�����������stub����ͬһ��Ŀ¼������rmiregistry

7.��д�ͻ��ˣ����пͻ���
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

8.������ͻ��ˡ�xiaopang�����������ˡ�this is name : xiaopang��

