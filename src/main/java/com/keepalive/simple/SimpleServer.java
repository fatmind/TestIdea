package com.keepalive.simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	public static void main(String[] args) throws Exception {
		
		//1.创建serverSocket
		ServerSocket server = new ServerSocket(10240);
		
		while(true) {
		
			//2.接收客户端连接
			Socket acceptor = server.accept();
			
			//3.通信
			BufferedReader br = new BufferedReader(new InputStreamReader(acceptor.getInputStream()));
			
			//4.输出msg
			System.out.println(br.readLine());
		}
		
		//server.close();
		
	}

}
