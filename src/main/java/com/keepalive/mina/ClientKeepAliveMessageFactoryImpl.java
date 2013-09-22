package com.keepalive.mina;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

public class ClientKeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {
	
	private static final String serverMsg = "#";
	private static final String clientMsg = "*";

	@Override
	public boolean isRequest(IoSession session, Object message) {
		
		if(clientMsg.equals(message)) {
			System.out.println("client : client -> server, keepalive reques");
			return true;
		} 
		
		return false;
	}

	@Override
	public boolean isResponse(IoSession session, Object message) {
		
		if(serverMsg.equals(message)) {
			System.out.println("client : server -> client, keepalive reponse");
			return true;
		}
		
		return false;
	}

	@Override
	public Object getRequest(IoSession session) {
		return clientMsg;
	}

	@Override
	public Object getResponse(IoSession session, Object request) {
		return serverMsg;
	}

}
