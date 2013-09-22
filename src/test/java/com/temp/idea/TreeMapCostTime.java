package com.temp.idea;

import java.util.TreeMap;

public class TreeMapCostTime {
	
	public static void main(String[] args) {
		
		TreeMap<String, String> cache = new TreeMap<String, String>();
		
		for(int i=0; i<100000; i++) {
			cache.put("key-" + i, "value-" + i);
		}
		
		String key = "key-788";
		long startTime = System.currentTimeMillis();
		System.out.println(cache.get(key));
		System.out.println(System.currentTimeMillis() - startTime);
	}

}
