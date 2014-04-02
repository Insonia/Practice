package milo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCoorperation {
	
	private static Accout account = new Accout();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Deposit());
		executor.execute(new Withdraw());
		
		System.out.println("Thread 1\t\tThread 2\t\tBalance");
	}
	
	public static class Deposit implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true){
					account.deposit((int)(Math.random() * 10) + 1);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	public static class Withdraw implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
				account.withdraw((int)(Math.random() * 10) + 1);
		}
		
	}
	
	private static class Accout{
		private static int balance = 0;
		private static Lock lock = new ReentrantLock();
		private static Condition newDeposit = lock.newCondition();
		
		public static int getBalance(){
			return balance;
		}
		
		public static void withdraw(int amount) {
			lock.lock();
			try {
				while (balance < amount) {
					System.out.println("\t\t\tWait for a deposit");
					newDeposit.await();
				}
				
				balance -= amount;
				System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				lock.unlock();
			}
		}
		
		public static void deposit(int amount){
			lock.lock();
			try {
				balance += amount;
				
				System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
				
				newDeposit.signalAll();
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				lock.unlock();
			}
		}
	}

}
