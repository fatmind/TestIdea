package nio.socket;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) throws Exception {
		
		Socket client = new Socket("10.13.120.20", 34757);
		int count = 0;

		OutputStream out = client.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		while(true) {
			bw.write("count = " + count + "\r\n");
			bw.flush();
			System.out.println("client sleep ...");
			Thread.sleep(1000);
		}
		
	}

}
