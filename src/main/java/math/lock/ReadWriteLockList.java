package math.lock;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteLockList<E> {
	
	private List<E> data;
	private ReadWriteLock lock;
	
	public ReadWriteLockList(int capacity) {
		data = new ArrayList<E>();
		lock = new ReadWriteLock();
	}
	
	public void add(E e) throws Exception {
        lock.writeLock();
        data.add(e);
        System.out.println(System.currentTimeMillis() + " - " + Thread.currentThread().getName() + " - " + lock.getWriters());
        lock.writeUnlock();
	}
	
	public E get(int index) throws Exception {
		lock.readLock();
		E d = data.get(index);
		System.out.println(System.currentTimeMillis() + " - " + Thread.currentThread().getName() + " - " + d + " - " + lock.getReaders());
		lock.readUnlock();
		return d;
	}
	
	
	public ReadWriteLock getLock() {
    	return lock;
    }

	public static void main(String[] args) throws Exception {
		
		final ReadWriteLockList<Long> list = new ReadWriteLockList<Long>(10);
		list.add(110L);
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i=0; i<5; i++) {
						list.get(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i=0; i<5; i++) {
						list.get(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "t2");
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for(int i=0; i<5; i++) {
						list.add(111L);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "t3");
		
		t1.start();
		t3.start();
		t2.start();
		
	}
	
	

}
