package thread;

public class SleepYield {

	public static void main(String[] args) throws Exception {
		
		SleepYield mutex = new SleepYield();
		
		/*
		 *	yield作用 
		 */
		/*
		for (int i = 1; i <= 2; i++) {
			new Thread(mutex.new T1(mutex)).start();
		}
		*/
		
		
		/*
		 *	yield作用 与 monitor
		 */
		/*
		for (int i = 1; i <= 2; i++) {
			new Thread(mutex.new T2(mutex)).start();
		}
		*/
		
		/*
		 *	yield调度规则
		 */
		Thread.currentThread().setPriority(6);
		new Thread(mutex.new T1(mutex)).start();
		Thread.yield();
		System.out.println("Hello");
		
	}

	class T1 implements Runnable {
		
		SleepYield mutex;
		
		public T1(SleepYield mutex) {
			this.mutex = mutex;
		}
		
		public void run() {
			System.out.print("1");
			//Thread.yield();
			try {
				Thread.sleep(100);  
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("2");
		}
	}

	
	class T2 implements Runnable {
		
		SleepYield mutex;
		public T2(SleepYield mutex) {
			this.mutex = mutex;
		}
		@Override
		public void run() {
			synchronized (mutex) {
				System.out.print("1");
				Thread.yield();
				System.out.print("2");
			}
		}
	}
}