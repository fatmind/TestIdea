package com.keepalive.mina;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Random;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MainClient {

	private static Random random = new Random();
	private static final int baseValue = 10;
	
	private static final int PORT = 9123;

	public static void main(String[] args) throws Exception {

		// 1.create connector
		NioSocketConnector connector = new NioSocketConnector();

		// 2.Create a Filter Chain
		connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		KeepAliveFilter keepAliveFilter = new KeepAliveFilter(new ClientKeepAliveMessageFactoryImpl());
		keepAliveFilter.setRequestInterval(300);
		keepAliveFilter.setRequestTimeout(30);
		keepAliveFilter.setRequestTimeoutHandler(new KeepAliveRequestTimeoutHandler() {

			@Override
			public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session)throws Exception {
				System.out.println("client : server无响应，关闭session");
				session.close(true);
			}
			
		});
		
		connector.getFilterChain().addLast("keep-alive", keepAliveFilter);

		// 3.create io handle
		connector.setHandler(new ClientHandler());

		// 4.bind to server
		IoSession session = null;

		try {
			ConnectFuture future = connector.connect(new InetSocketAddress("127.0.0.1", PORT));
			future.await();
			session = future.getSession();
			while (true) {
				session.write("hello server");
				Thread.sleep(20000);
			}
		} catch (Exception e) {
			System.out.println(e); 
		} finally {
			if (session != null)
				session.close(true);
		}

	}

}
