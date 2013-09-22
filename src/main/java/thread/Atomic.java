package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Atomic {

	Object mutex = new Object();

	public void handleSync() {
		synchronized (mutex) {
			// ....
		}
	}

	Lock lock = new ReentrantLock();
	public void handleLock() throws Exception {
		lock.tryLock(1000, TimeUnit.SECONDS); 
		try {
			// access the resource protected by this lock
		} finally {
			lock.unlock();
		}
	}
}
