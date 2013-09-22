package com.temp.idea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * 100K数据，存储1000份所占内存大小
 * @author bohan.sj
 */
public class TreeMapCostSize {
	
	public static void main(String[] args) throws Exception {
		
		Thread.sleep(1000 * 5);
		TreeMap<String, String> store = new TreeMap<String, String>();
		
		StringBuilder sb = new StringBuilder();
		InputStreamReader isr = new InputStreamReader(TreeMapCostSize.class.getResourceAsStream("custom-ranklist-size.txt"));
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		
		for(int i=0; i<1000; i++) {
			store.put("pid=1&i" + i, sb.toString());
		}
		
		System.out.println("complete success.");
		
		Thread.sleep(1000 * 60 * 5);
	}

}
