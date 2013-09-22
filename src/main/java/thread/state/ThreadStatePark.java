package thread.state;

import java.util.concurrent.locks.LockSupport;

public class ThreadStatePark {
	
	public static void main(String[] args) throws Exception {
		
		
		Thread t1 = new Thread(new ParkTask());
		t1.start();
		Thread t2 = new Thread(new ParkTask());
		t2.start();
		Thread t3 = new Thread(new ParkTask());
		t3.start();
		
		Thread.sleep(1000);
		
		System.out.println("t1 state - " + t1.getState()); 
		System.out.println("t2 state - " + t2.getState());
		System.out.println("t3 state - " + t3.getState());
		
		
		Thread.sleep(1000);
		
		LockSupport.unpark(t1);
		System.out.println("t1 state - " + t1.getState());
		LockSupport.unpark(t2);
		System.out.println("t2 state - " + t2.getState());
		LockSupport.unpark(t3);
		System.out.println("t3 state - " + t3.getState());
	}

}


class ParkTask implements Runnable {

	
	@Override
    public void run() {
		try {
			String name = Thread.currentThread().getName();
			System.out.println(name + " - wait start ... ");
			LockSupport.park();
			System.out.println(name + " - wait end ... start sleep ... ");
			Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
	        e.printStackTrace();
        } 
    }
	
}

