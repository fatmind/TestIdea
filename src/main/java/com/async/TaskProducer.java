package com.async;

public class TaskProducer {
	
	public static void main(String[] args) throws Exception{
		
		TaskDispatch<LogInfo> dispatch = new TaskDispatch<LogInfo>();
		
		TaskConsumer<LogInfo> consumer = new TaskConsumer<LogInfo>(dispatch);
		new Thread(consumer).start();
		
		for(int i=1; i<10; i++) {
			LogInfo logInfo = new LogInfo(new TaskProducer(), System.currentTimeMillis(), "ÈÕÖ¾ - " + i);
			Task<LogInfo> task = new Task<LogInfo>(logInfo, dispatch);
			
			Thread t = new Thread(task);
			t.start();
			//t.sleep(2000);
		}

	}

}
