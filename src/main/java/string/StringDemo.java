package string;

import java.net.URLEncoder;
import java.util.Arrays;

public class StringDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		String str = "hello";
		System.out.println(str.indexOf("l"));
		
		String[] t = new String[]{"1", "2"};
		System.out.println(Arrays.asList(t).size());
		
		str = "{\"name\":\"中国\"}";
		System.out.println(URLEncoder.encode(str, "UTF-8"));
		

	}

}
