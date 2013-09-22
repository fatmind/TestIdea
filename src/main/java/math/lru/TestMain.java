package math.lru;

import java.util.HashMap;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>(3);
		map.put("key-1", "value-1");
		map.put("key-2", "value-1");
		map.put("key-3", "value-1");
		map.put("key-4", "value-1");
		map.put("key-5", "value-1");
		System.out.println(map.size());
		map.remove("key-1");
		System.out.println(map.size());
	}

}
