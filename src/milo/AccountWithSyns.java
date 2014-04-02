package milo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyns {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i= 0 ;i < 100;i++)
			executor.execute(new AddPenny());
		
		executor.shutdown();
		
		while (!executor.isTerminated()) {
			
		}
		
		System.out.println(account.getBalance());
	}
	
	private static class AddPenny implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			account.deposit(1);
		}
		
	}
	
	private static class Account{
		private Lock lock = new ReentrantLock();
		private int balance = 0;
		
		public int getBalance(){
			return balance;
		}
		
		public void deposit(int amount){
			lock.lock();
			
			try {
				int newBalance = balance + amount;
				
				Thread.sleep(10);
				
				balance = newBalance;
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				lock.unlock();
			}
		}
	}
}
