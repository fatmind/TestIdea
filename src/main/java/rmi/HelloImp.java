package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImp extends UnicastRemoteObject implements Hello {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public HelloImp(String name) throws RemoteException {
		this.name = name;
	}
	
	public String disName() throws RemoteException {
		System.out.println("this is name : " + name);
		return name;
	}
	

}
