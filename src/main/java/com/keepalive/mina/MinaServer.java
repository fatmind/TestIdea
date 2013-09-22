package com.keepalive.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {

	private static final int PORT = 9123;

	public static void main(String[] args) throws IOException {
    	
        // Create the acceptor [IOService]
        IoAcceptor acceptor = new NioSocketAcceptor();
        
        // Add two filters : a logger and a codec [FilterChain]
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
   
		KeepAliveFilter keepAliveFilter = new KeepAliveFilter(new ServerKeepAliveMessageFactoryImpl());
		keepAliveFilter.setRequestInterval(15);
		keepAliveFilter.setRequestTimeout(60);
		keepAliveFilter.setRequestTimeoutHandler(new KeepAliveRequestTimeoutHandler() {

			@Override
			public void keepAliveRequestTimedOut(KeepAliveFilter filter,
					IoSession session) throws Exception {
				System.out.println("server : client无响应，关闭session");
				session.close(true);
			}
		});
		
		acceptor.getFilterChain().addLast("keep-alive", keepAliveFilter);
        
        // Attach the business logic to the server [IOHandle]
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 15);
        acceptor.setHandler(new ServerHandler());
        
        // Bind
        acceptor.bind(new InetSocketAddress(PORT));
    }
}
