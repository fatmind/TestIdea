package concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreRiskDemo {
	
	
	public static void main(String[] args) throws Exception {
		SemaphoreRiskDemo main = new SemaphoreRiskDemo();
		main.execute();
	}
	

	private Semaphore semaphore = new Semaphore(1);
	
	public void execute() throws Exception {
		
		Thread t1 = new Thread(this.new Task(1));
		t1.start();
		
		Thread t2 = new Thread(this.new Task(2));
		t2.start();
		
		Thread.sleep(1000);
		Semaphore oldsSemaphore = semaphore;
		
		semaphore = new Semaphore(4);
		System.out.println("main new semaphore ...");
		
		int size = oldsSemaphore.availablePermits() + oldsSemaphore.getQueueLength();
		semaphore.acquire(size);
		oldsSemaphore.release(oldsSemaphore.getQueueLength());	//释放被阻塞的线程
	}
	
	
	class Task implements Runnable {
		
		int num;
		
		public Task(int num) {
			this.num = num;
		}
		
		public void run() {
			System.out.println(num + "ready to acquire semaphore ... " + semaphore.availablePermits());
			semaphore.acquireUninterruptibly(); 
			System.out.println(num + " acquire semaphore ... " + semaphore.availablePermits());
			try {
	            Thread.sleep(1000*2);
            } catch (InterruptedException e) {
	            e.printStackTrace();
            }
			System.out.println(num + " ready to realse semaphore ... " + semaphore.availablePermits());
			semaphore.release();
			System.out.println(num + " realse semaphore ... " + semaphore.availablePermits());
        }
		
	}

}
