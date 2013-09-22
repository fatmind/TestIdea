package jvm.hook;

public class SimulateShutdownHookDeadLock {

	private static Object lock = new Object();

	public static void main(String[] args) {

		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				System.out.println("shutdown hook calling ...");
				synchronized (lock) {
					System.out.println("acquired lock, shutdown hook finish");
				}
			}

		});

		synchronized (lock) {
			System.out.println("main acquire lock, exit");

			System.exit(-1);

			System.out.println("jvm exit");
		}

	}

}
