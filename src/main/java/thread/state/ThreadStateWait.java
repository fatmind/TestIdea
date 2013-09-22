package thread.state;

public class ThreadStateWait {
	
	public static void main(String[] args) throws Exception {
		
		Object obj = new Object();
		Thread t1 = new Thread(new WaitTask(obj));
		t1.start();
		Thread t2 = new Thread(new WaitTask(obj));
		t2.start();
		Thread t3 = new Thread(new WaitTask(obj));
		t3.start();
		
		Thread.sleep(1000);
		
		System.out.println("t1 state - " + t1.getState()); 
		System.out.println("t2 state - " + t2.getState());
		System.out.println("t3 state - " + t3.getState());
		
		synchronized (obj) {
			System.out.println("main thread notifyall() ...");
			obj.notifyAll();
        }
		
		System.out.println("t1 state - " + t1.getState()); 
		System.out.println("t2 state - " + t2.getState()); 
		System.out.println("t3 state - " + t3.getState()); 
	}

}

class WaitTask implements Runnable {

	private Object obj;
	
	public WaitTask(Object obj) {
		this.obj = obj;
	}
	
	@Override
    public void run() {
		try {
			synchronized (obj) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " - wait start ... ");
				obj.wait();
				System.out.println(name + " - wait end, start sleep ... ");
				Thread.sleep(1000 * 10);
				System.out.println(name + " - sleep end ... ");
            }
        } catch (InterruptedException e) {
	        e.printStackTrace();
        } 
    }
	
}

