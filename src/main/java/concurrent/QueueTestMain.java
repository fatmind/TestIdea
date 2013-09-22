package concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueTestMain {

	public static void main(String[] args) throws Exception {
		
		/*
		 * queue size = 6378
		 * total costTime = 1.401675597E9, average costTime = 140167.5597
		 */
		//PriorityBlockingQueueSet<CacheEntry<String, String>> cacheQueue = new PriorityBlockingQueueSet<CacheEntry<String, String>>();
		
		/*
		 * queue size = 10000
		   total costTime = 1.9643001E7, average costTime = 1964.3001
		 */
		PriorityBlockingQueue<CacheEntry<String, String>> cacheQueue = new PriorityBlockingQueue<CacheEntry<String, String>>();
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 80, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		
		int failCount = 0;
		int capacity = 10000;
		ArrayBlockingQueue<Long> statistics = new ArrayBlockingQueue<Long>(capacity);
		
		for(int i=0; i<capacity; i++) {
			AddJob job = new AddJob(cacheQueue, statistics);
			try {
				executor.execute(job);
				Thread.sleep(10); //平均每秒100
			}catch (Exception e) {
				failCount++;
			}
		}
		System.out.println("failCount = " + failCount);
		
		Thread.sleep(1000 * 120);
		System.out.println("queue size = " + cacheQueue.size());
		
		Double totalCostTime = 0D;
		Long singleCostTime = 0L;
		int size = statistics.size();
		while((singleCostTime=statistics.poll()) != null) {
			totalCostTime = totalCostTime + singleCostTime;
		}
		
		System.out.println("total costTime = " + totalCostTime + ", average costTime = " + (totalCostTime/size)); 
		
		/*
		CacheEntry<String, String> cacheEntry;
		while((cacheEntry=cacheQueue.poll()) != null) {
			System.out.println("priority = " + cacheEntry.getPriority() + ", key = " + cacheEntry.getKey());
		}
		*/
		
	}
		
}


class AddJob implements Runnable{
	final int baseValue = 10000;
	final Random random = new Random();
	private BlockingQueue<CacheEntry<String, String>> entryQueue;
	private ArrayBlockingQueue<Long> statistics;
	
	public AddJob(BlockingQueue<CacheEntry<String, String>> entryQueue, ArrayBlockingQueue<Long> statistics) {
		this.entryQueue = entryQueue;
		this.statistics = statistics;
	}

	public void run() {
		CacheEntry<String, String> entry = new CacheEntry<String, String>();
		int r = random.nextInt(baseValue);
		entry.setKey("key-" + r);
		entry.setPriority(r);
		Long startTime = System.nanoTime();
		entryQueue.offer(entry);
		statistics.add((System.nanoTime()-startTime));
	}
	
}

class CacheEntry<K, V> implements Comparable<CacheEntry<K, V>> {

	private K key;
	private V value;
	private int priority;

	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int compareTo(CacheEntry<K, V> o) {
		int oPriority = o.priority;
		if (priority > oPriority) {
			return 1;
		} else if (priority < oPriority) {
			return -1;
		} else {
			return 0;
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		CacheEntry other = (CacheEntry) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
}

