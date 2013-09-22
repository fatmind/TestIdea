package com.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 原生Java Http	
 * @author shi
 */
public class HttpSimpleDemo {

	public static void main(String[] args) {

		URL url = null;
		HttpURLConnection connection = null;
		
		InputStream in = null;
		BufferedReader br = null;
		
		try {
			
			url = new URL("http://www.baidu.com");
			
			/**
			 * 第一次请求
			 */
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			in = connection.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "gbk"));
			String line = null;
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
			//br.close();
			//in.close();
			
			
			Thread.sleep(1000 * 60);
			
			
			/**
			 * 第二次请求
			 */
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			in = connection.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, "gbk"));
			line = null;
			while((line=br.readLine()) != null) {
				System.out.println(line);
			}
			//br.close();
			//in.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
			}catch (Exception e) {
				
			}
		}

	}

}
