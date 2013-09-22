package thread;


/**
 * 1. 阻塞等待线程结束
 * 2. 若持有锁，则释放  
 */
public class Join {
	
	
	public static void main(String[] args) throws Exception {
		
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println("join thread sleep over ...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		
		Join join = new Join();
		new Thread(join.new T1(t)).start();
		new Thread(join.new T1(t)).start();
		
		//t.join();
		System.out.println("main thread over ....");
		
	}
	
	class T1 implements Runnable {
		Thread t;
		public T1(Thread t) {
			this.t = t;
		}
		@Override
		public void run() {
			synchronized (t) {
				try {
					System.out.println("1");
					t.join();
					System.out.println("2");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
