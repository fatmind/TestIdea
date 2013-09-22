package thread;

public class Interrupt {
	
	public static void main(String[] args) throws Exception {
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				/*
				 * 1. sleep
				 */
				
				try {
	                Thread.sleep(10000);
                } catch (InterruptedException e) {
	                e.printStackTrace();
                }
                System.out.println("\r\n"); 
                System.out.println("interrupt stauts is " + Thread.currentThread().isInterrupted());
                
				try {
	                Thread.sleep(10000);
	                System.out.println("thread 100000 ....");
                } catch (InterruptedException e) {
	                e.printStackTrace();
                }
                
                
                /*
                 * 2.normal execute
                 */
                /*
                for(int i=0; i<100000; i++) {
                	System.out.println(i);
                }
                */
			}
		});
		
		t.start();
		
		Thread.sleep(1000);
		
		t.interrupt();
		
	}

}
