package concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
	
	public static void main(String[] args) {
		ExecutorDemo target = new ExecutorDemo();
		target.execute();
	}
	
	
	BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(3);
	ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 100, TimeUnit.SECONDS, queue);
	
	public void execute() {
		int failCount = 0;
		
		for(int i=0; i<10; i++) {
			try {
				threadPoolExecutor.execute(new PrintTask("executor_service_"  + i));
			}catch (RejectedExecutionException e) {
				failCount++;
			}
		}
		
		System.out.println("queue size : " + queue.size());
		System.out.println("success executing ...");
		System.out.println("fail count : " + failCount);
	}
	
	
	public class PrintTask implements Runnable {

		private String name;
		public PrintTask(String name) {
			this.name = name;
		}
		
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("name : " + name + " , queue size : " + queue.size());
		}
	}

}
