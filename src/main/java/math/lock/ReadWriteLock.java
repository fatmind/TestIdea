package math.lock;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLock {
	
	private Map<Long, Integer> readers = new HashMap<Long, Integer>();
	private int writers;
	private int writeReqs;
	private long currentWriteThreadId;
	
	
	public synchronized void readLock() throws Exception {
		while(!isCanRead()) {
			wait();
		}
		long tid = Thread.currentThread().getId();
		readers.put(tid, getReadCount(tid) + 1);
	}
	
	public synchronized void readUnlock() throws Exception {
		long tid = Thread.currentThread().getId();
		if(readers.get(tid) == null) {
			throw new IllegalMonitorStateException("this thread dont have read lock");
		}
		int count = getReadCount(tid) - 1;
		if(count == 0) {
			readers.remove(tid);
		} else {
			readers.put(tid,  count);
		}
		notifyAll();
	}
	
	/**
	 * 为保证：a、解决‘写饥饿’; b、读重入 ; c、写到读重入 <br>
	 * 优先级如下：currentWriteThreadId -> writers -> readers -> writeReqs 
	 * @return
	 */
	private boolean isCanRead() {
		if(Thread.currentThread().getId() == currentWriteThreadId) return true;
		if(writers > 0) return false;
		if(readers.get(Thread.currentThread().getId()) != null) return true;
		if(writeReqs > 0) return false;
		return true;
	}
	
	private int getReadCount(long tid) {
		Integer count = readers.get(tid);
		return count == null ? 0 : count;
	}
	

	
	public synchronized void writeLock() throws Exception {
		writeReqs++;
		while(!isCanWrite()) {
			wait();
		}
		writeReqs--;
		writers++;
		currentWriteThreadId = Thread.currentThread().getId();
	}
	
	public synchronized void writeUnlock() throws Exception {
		writers--;
		currentWriteThreadId = 0;
		notifyAll();
	}
	
	private boolean isCanWrite() {
		if(Thread.currentThread().getId() == currentWriteThreadId) return true;
		if(writers > 0) return false;
		if(readers.size() > 0) return false;
		return true;
	}
	


	public Map<Long, Integer> getReaders() {
    	return readers;
    }

	public int getWriters() {
    	return writers;
    }
	
}
