package thread;

public class Monitor {
	
	
	public static synchronized void handleStatic() {
		System.out.println("static method synchronized ..."); 
	}
	
	public synchronized void handle() throws Exception {
		Thread.sleep(1000);
		System.out.println("normal method synchronized");
	}
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
	                new Monitor().handle();
                } catch (Exception e) {
	                e.printStackTrace();
                }
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				Monitor.handleStatic();
			}
		});
		
		t1.start();
		t2.start();
		t2.start();
		
	}
	

}


