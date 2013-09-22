package com.pagebreak;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxMain {
	
	public static void main(String[] args) {
		
//		String regx = "[(\\w+([-+.]\\w+))\\*]*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
//		Pattern p = Pattern.compile(regx);  
//		Matcher m = p.matcher("*@taobao.com");
//		if(m.matches()) {
//			System.out.println("成功 。。。");
//			System.out.println(m.group()); 
//		}
		
		/*
		String str = "10$shijian@taobao.com";
		String[] strs = str.split("\\$");
		System.out.println(strs);
		*/
		
		
		String str = "2010.5-19";
		String regxStr = "\\d+([\\.\\+-_]*\\d*)*";
		// String regxStr = "\d+[_-\.]*\d*" 无法解决
		Pattern pattern = Pattern.compile(regxStr);
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			System.out.println("success");
		}
		
	}

}
