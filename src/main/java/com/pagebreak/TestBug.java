package com.pagebreak;

import java.net.URLDecoder;

public class TestBug {
	
	public static void main(String[] args) throws Exception {
		String temp = "";
		//String[] str = new String[]{"%C5%AE%CA%BF%C3%AB%D2%C2%0D","%C4%D0%D7%B0%0D","%C4%D0%D7%B0%0D","%B9%FA%B2%FA%CA%D6%BB%FA%0D"};
		String[] str = "%B1%CA%BC%C7%B1%BE%B5%E7%C4%D4%0D,%C1%AC%D2%C2%C8%B9%0D,%B3%E8%CE%EF%CA%B3%C6%B7%0D,%B9%FA%B2%FA%CA%D6%BB%FA%0D".split(",");
		for(int i=0; i<str.length; i++) {
			temp = URLDecoder.decode(str[i], "gbk");
			System.out.println(temp);
		}
	}

}
