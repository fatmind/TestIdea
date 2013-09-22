package com.keepalive.simple;

import java.io.OutputStreamWriter;
import java.net.Socket;

public class SimpleClient {
	
	public static void main(String[] agrs) throws Exception {
		
		//1.建立socket连接
		Socket client = new Socket("10.232.133.106", 10240);
		
		//2.通信
		OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
		writer.write("hello world ...");
		
		Thread.sleep(1000 * 300);
		
		//3.关闭连接
		writer.close();
		client.close();
	}

}
