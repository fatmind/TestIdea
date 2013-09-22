package io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

public class IoStructDemo {
	
	public static void mian(String[] args) throws Exception {
		
		InputStream in = IoStructDemo.class.getResourceAsStream("");
		
		BufferedInputStream bis = new BufferedInputStream(in);
		
		DataInputStream dis = new DataInputStream(bis);
		
		dis.readDouble();
		
	}

}
