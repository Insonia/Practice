package milo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i= 0; i< 100; i++)
			executor.execute(new AddPennyTask());
		
		executor.shutdown();
		
		while (! executor.isTerminated()) {
			
		}
		
		System.out.println(account.getBalance());
	}
	
	private static class AddPennyTask implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
//			synchronized (account) {
//				account.deposit(1);
//			}
			account.deposit(1);
		}
		
	}
	
	private static class Account{
		private int balance = 0;
		
		public int getBalance(){
			return balance;
		}
		
		public synchronized void deposit(int amount){
			int newBalance = balance + amount;
			
			try{
				Thread.sleep(10);
			}catch(Exception e){
				
			}
			
			balance = newBalance;
		}
	}

}
