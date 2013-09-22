package math.string;

import java.util.HashMap;

public class StringParse {

	private static final String separator = "\n";

	public static void main(String[] args) {
			
		String str = "p0=shi\np1=shi\np2=shi";
		HashMap<String, String> data = new HashMap<String, String>();
		
		String[] mapStr = str.split(separator);
		for(String s : mapStr) {
			String[] arr = s.split("=");
			data.put(arr[0], arr[1]);
		}
		
		System.out.println(data.size());
		
	}

}
