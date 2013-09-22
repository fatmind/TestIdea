package com.keepalive.mina;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class ServerHandler extends IoHandlerAdapter {


	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		cause.printStackTrace();
	}


	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String str = message.toString();

		if (str.trim().equalsIgnoreCase("quit")) {
			session.close(true);
			return;
		}

		// Send the current date back to the client
		Date date = new Date();
		session.write(date.toString());
		System.out.println("server : msg written ...");
	}

	

}
