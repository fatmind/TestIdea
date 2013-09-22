package com.temp.idea;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectSizeCalculator {

	public static int calcSize(Serializable o) throws Exception {
		int ret = 0;
		DumbOutputStream buf = new DumbOutputStream();
		ObjectOutputStream os = null;
		
		os = new ObjectOutputStream(buf);
		os.writeObject(o);
		ret = buf.count;
		os.close();
		return ret;
	}
	
	
	public static void main(String[] args) throws Exception {
		String key = "1111111111111111111111111111111111111111";
		String value = "11111111111111111111111111111111111111";
		CacheEntry cacheEntry = new CacheEntry(key, value);
		
		long startTime = System.nanoTime();
 		calcSize(cacheEntry);
		System.out.println("calcSize cost time : " + (System.nanoTime() - startTime));
	}

}


class DumbOutputStream extends OutputStream {
	int count = 0;
	public void write(int b) throws IOException {
		count++;
	}
}

class CacheEntry implements Serializable {

	private static final long serialVersionUID = 1L;
	private Object key;
	private Object value;
	
	private List<String> children;
	
	public CacheEntry(Object key, Object value) {
		this.key = key;
		this.value = value;
		this.children = new ArrayList<String>();
		for(int i=0; i<100; i++) {
			children.add(key.toString() + value.toString());
		}
	}
}