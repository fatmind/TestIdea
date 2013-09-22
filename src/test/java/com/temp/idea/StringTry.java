package com.temp.idea;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTry {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		/*
		String str = "1?&eurl=3";
		int startIndex = str.indexOf("eurl") + 5;
		System.out.println(str.substring(startIndex));
		*/
		
//		String res = URLEncoder.encode("http://click.simba.taobao.com/cc_im?p=&s=1280383893&k=249&e=TrR3cfabxZxUHZ18" +
//				"2I%2FaROS383WkO1zWvK1LxKRFotwCCjir3kTS3TEFPVGviHB2pzNTUImYKOSMI6OTSf0pIki1gSvsNGuS3%2FZkUan%" +
//				"2F7BWecqUDlLfGq3JQep5CO7XWq05%2Fdlvk4dNTJu0shucsrebvotecWc0BfA0bVCpIz50ZIr8b1QHpWQF2FsdR" +
//				"2cLNO3lIeinHYDfna61nnhl1Y8qbgAeuNWKgPtUA87TQz7JtHpqyADOqEw%3D%3D", "GBK");
//		System.out.println(res);
		
		Pattern pattern = Pattern.compile("^\\d+~(\\w+)~(\\d+)~(\\w+)$");
		String str = "1348070400065~trident_features~2~ad_outer";
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			System.out.println(matcher.group(1) + " - " + matcher.group(2) + " - " + matcher.group(3));
		}
		
		
		System.out.println("1348070400065~trident_features".getBytes().length);
		
		System.out.println(0.10d);
		System.out.println("0.10");
		
	}

}
