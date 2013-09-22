package concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceMain {

	public static void main(String[] args) {

		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("normal output ...");
				throw new RuntimeException("run time exception ...");
			}
		}, 1000, 1000, TimeUnit.MILLISECONDS);
		
	}

}
