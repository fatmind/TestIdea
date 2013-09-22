package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayList2CopyOnWriteList {
	
	public static void main(String[] args) {
		singleThreadTest();
	}
	
	
	private static void singleThreadTest() {
		List<String> arrayList = new ArrayList<String>();
		prepareData(arrayList);
		long startTime = System.nanoTime();
		for(int i=0; i<arrayList.size(); i++) {
			arrayList.get(i);
		}
		long endTime = System.nanoTime();
		System.out.println("ArrayList cost time : " + (endTime - startTime));
		
		
		List<String> copyOnWriteList = new CopyOnWriteArrayList<String>();
		prepareData(arrayList);
		startTime = System.nanoTime();
		for(int i=0; i<copyOnWriteList.size(); i++) {
			arrayList.get(i);
		}
		endTime = System.nanoTime();
		System.out.println("CopyOnWriteArrayList cost time : " + (endTime - startTime));
		
	}
	
	
	
	private static void prepareData(List<String> collection) {
		for(int i=0; i<100000; i++) {
			collection.add("Hello-" + i);
		}
	}
	

}
