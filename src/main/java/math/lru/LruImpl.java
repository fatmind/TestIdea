package math.lru;

import java.util.concurrent.ConcurrentHashMap;

//TODO 1.哈勃监控问题

public class LruImpl {
	
	private final int capacity = 1000;
	private final double factor = 0.75;
	private final int threshold = (int)(capacity * factor) - 1;
	private ConcurrentHashMap<KeyDao, AdDao> store = new ConcurrentHashMap<KeyDao, AdDao>(capacity);
	private KeyDao top = null;
	private KeyDao bottom = null;
	
	public synchronized void putToCache(KeyDao key, AdDao data) {
		
		if(store.size() > threshold) {
			System.out.println("store.size() is " + store.size()+ ". clean processor is starting ...");
			removeEldestEntry();
		}
		
		if(store.containsKey(key)) {
			KeyDao old = store.get(key).getKey();
			KeyDao pre = old.getPre();
			KeyDao next = old.getNext();
			
			if(pre == null) {
				//at time, old is top
			} else if(next == null) {
				//at time, old is bottom
				old.setPre(null);
				pre.setNext(null);
				bottom = pre;
			} else {
				pre.setNext(next);
				next.setPre(pre);
			}
	
		}else {
			if(top != null) {
				top.setPre(key);
				key.setNext(top);
				top = key;
			}else { 
				//first time, top and bottom point the same object
				bottom = key;
				top = key;
			}
		
			data.setKey(key);
			store.put(key, data);
			System.out.println("--------- " + store.size() + " ----------");
		}
	}
	
	private void removeEldestEntry() {
		KeyDao pre = bottom.getPre();
		pre.setNext(null);
		bottom.setPre(null);
		store.remove(bottom);
		bottom = pre;
		
		System.out.println("it be removed. key = " + bottom.getValue());
	}
	
}
