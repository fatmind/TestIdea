package thread.state;

class RunnableTask implements Runnable {

	private Object obj;
	
	public RunnableTask(Object obj) {
		this.obj = obj;
	}
	
	@Override
    public void run() {
		try {
			synchronized (obj) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " - wait start ... ");
				obj.wait();
				System.out.println(name + " - wait end ... start sleep ... ");
				Thread.sleep(1000 * 60);
            }
        } catch (InterruptedException e) {
	        e.printStackTrace();
        }
    }
	
}
