package com.async;


public class Task<T> implements Runnable {

	private T target;
	private TaskDispatch<T> dispatch; 
	
	public Task(T target, TaskDispatch<T> dispatch) {
		this.target = target;
		this.dispatch = dispatch; 
	}
	
	public void run() {
		dispatch.addTask(target);
	} 

}
