package com.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {


	public static void main(String[] args) throws Exception {
		
		HttpClient httpclient = new DefaultHttpClient();
		

		ResponseHandler<String> handler = new ResponseHandler<String>() {
		    public String handleResponse(
		            HttpResponse response) throws ClientProtocolException, IOException {
		        HttpEntity entity = response.getEntity();
		        if (entity != null) {
		            return EntityUtils.toString(entity);
		        } else {
		            return null;
		        }
		    }
		};
		
		/**
		 * 第一次请求
		 */
		HttpGet httpget = new HttpGet("http://10.232.35.184:10240/util-web/encrypt.jsp");
		String response = httpclient.execute(httpget, handler);
		System.out.println(response);

		Thread.sleep(1000 * 60);
		
		/**
		 * 第二次请求
		 */
		//httpget = new HttpGet("http://www.baidu.com");
		response = httpclient.execute(httpget, handler);
		System.out.println(response);
		
		
		System.out.println("It is over");
		
		
		Thread.sleep(1000 * 60);
		
		
	}
	
}
