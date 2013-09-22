package com.async;

import java.util.List;

public class TaskConsumer<T> implements Runnable {

	public List<T> tasks;

	public TaskConsumer(TaskDispatch<T> dispatch) {
		this.tasks = dispatch.getBuffer();
	}

	public void run() {
		boolean isActive = true;
		try {
			while (isActive) {
				synchronized (tasks) {
					if (tasks.size() < TaskDispatch.getDEFAULT_BUFFER_SIZE()) {
						tasks.wait();
					} else {
						for (int i = 0; i < tasks.size(); i++) {
							T task = tasks.get(i);
							System.out.println(task);
						}
						tasks.clear();
						tasks.notifyAll();
					}
				}
			}
		} catch (InterruptedException e) {
			isActive = false;
			e.printStackTrace();
		}

	}

}
