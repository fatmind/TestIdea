package com.threadlocal;

public class MainDemo {


	public static void main(String[] args) {
		
		//Account account = new CommonAccount();
		Account account = new SafeAccount();
		
		Thread t1 = new Thread(new People(account));
		Thread t2 = new Thread(new People(account));
		
		t1.start();
		t2.start();
		
	}
	
	
	static class People implements Runnable {

		private Account account;
		
		public People(Account account) {
			this.account = account;
		}
		
		@Override
		public void run() {
			account.save(100);
			System.out.println(this + " : " + account.getMoney());
		}
		
	}
	

}
