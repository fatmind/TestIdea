package com.keepalive.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ClientHandler extends IoHandlerAdapter {

	public void messageReceived(IoSession session, Object message) {
		System.out.println("client revice msg : " + message.toString());
	}
		
}
