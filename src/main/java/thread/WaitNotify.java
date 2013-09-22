package thread;

public class WaitNotify {
	
	public static void main(String[] args) throws Exception {
		
		WaitNotify monitor = new WaitNotify();
		
		Thread t1 = new Thread(monitor.new InterruptTask(monitor, "t1"));
		t1.start();
		Thread t2 = new Thread(monitor.new InterruptTask(monitor, "t2"));
		t2.start();

		Thread.sleep(1000);
		
		synchronized (monitor) { 
			System.out.println("main is over ...");
			monitor.notify();
			monitor.notifyAll();
		}
		
		monitor.wait();
	}
	
	class InterruptTask implements Runnable {

		WaitNotify monitor;
		String name;
		public InterruptTask(WaitNotify monitor, String name) {
			this.monitor = monitor;
			this.name = name;
		}
		
		@Override
		public void run() {
			synchronized (monitor) {
				try {
					monitor.wait();
					Thread.sleep(1000);
					System.out.println(name + " - wait over ....");
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println(name + " - interrupted ...");
				}
			}
		}
	}
	
}
