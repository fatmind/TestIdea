package math.rwl;


public class ReadWriteLockDemo {

	public static void main(String[] args) {
		
		final ReadWriteList target = new ReadWriteList();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				target.get(Thread.currentThread().getName(), 1);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				target.get(Thread.currentThread().getName(), 2);
			}
		});
	
		t1.start();
		t2.start();
	}
	
}

class ReadWriteList {
	
	public synchronized void get(String threadName, int flag) {
		if(flag == 1) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis() + " - " + threadName);
	}
	
}
