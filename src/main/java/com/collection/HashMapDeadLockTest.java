package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HashMapDeadLockTest {

	public static void main(String[] args) throws InterruptedException {

		final ExecutorService executor = Executors.newFixedThreadPool(10);

		final Map<Object, Object> map = new HashMap<Object, Object>();
		final Collection<Callable<Object>> actions = new ArrayList<Callable<Object>>();
		int i = 0;
		while (i++ < 1000) {
			final Object o = new Object();
			actions.add(new Callable<Object>() {
				public Object call() throws Exception {
					map.put(o, o);
					return null;
				}
			});
			actions.add(new Callable<Object>() {
				public Object call() throws Exception {
					map.put(new Object(), o);
					return null;
				}
			});
			// actions.add(new Callable<Object>() {
			// public Object call() throws Exception {
			// for (Iterator iterator = map.entrySet().iterator();
			// iterator.hasNext();) {
			// iterator.next();
			// }
			// return null;
			// }
			// });
		}
		executor.invokeAll(actions); 
		System.exit(0);

	}

}
