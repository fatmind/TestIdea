package nio.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws Exception {
		
		ServerSocket listener = new ServerSocket(34757);
		Socket socket = listener.accept();
		
		new Thread(new HandleSocket(socket)).start();
		System.out.println("main execute end ..."); 
	}
	
	static class HandleSocket implements Runnable {
		
		Socket socket;
		
		public HandleSocket(Socket socket) {
			this.socket = socket;
        }
		
		@Override
        public void run() {
	        try {
	        	InputStream in = socket.getInputStream();
	        	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        	String line = null;
	        	while((line=br.readLine()) != null) {
		            System.out.println("client : " + line);
	        	}
            } catch (Exception e) {
	            e.printStackTrace();
            }
        }
		
	}

}
