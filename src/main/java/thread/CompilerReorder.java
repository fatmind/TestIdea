package thread;

/**
 * 会出现(0,0)现象吗  ?
 * @author bohan.sj
 */
public class CompilerReorder {

	static int x = 0, y = 0;
	static int a = 0, b = 0;

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0; i<10000000; i++) {
			
			x = 0;
			y = 0;
			a = 0;
			b = 0;
		
			Thread one = new Thread(new Runnable() {
				public void run() {
					a = 1;
					x = b; //保证 x=0,y!=0
				}
			});
			
			Thread two = new Thread(new Runnable() {
				public void run() {
					b = 1;
					y = a; //保证 y=0,x!=0
				}
			});
			
			one.start();
			two.start();
			one.join();
			two.join();
			
			
			if(x==0 && y==0) {
				System.out.println("reorder success ...");
				System.out.println("(" + x + "," + y + ")");
			}
			  
			
			//System.out.println("(" + x + "," + y + ")");
		}
	}

}
