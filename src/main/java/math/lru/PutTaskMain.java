package math.lru;

import java.util.Random;

public class PutTaskMain {

	private LruImpl lru = new LruImpl();
	
	public static void main(String[] args) {
		new PutTaskMain().init();
	}
	
	public void init() {
		for(int i=0; i<50; i++) {
			new Thread(new PutTask()).start();
		}
	}
	
	class PutTask implements Runnable {
		
		int count = 0;
		Random random = new Random();
		
		public void run() {
			while(count < 50) {
				int digit = random.nextInt(10000);
				KeyDao key = new KeyDao("key:" + digit);
				AdDao data = new AdDao("content:" + digit);
				lru.putToCache(key, data);
				count++;
				//System.out.println(Thread.currentThread() + " : " + count);
			}
		}
		
	}

}
