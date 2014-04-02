package milo;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
	private static Buffer buffer = new Buffer();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(new Producer());
		executor.execute(new Consumer());
		
		executor.shutdown();
	}
	
	public static class Producer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				int i=1;
				while(true){
					System.out.println("Producer writing!");
				buffer.write(i++);
				Thread.sleep((int)(Math.random() * 1000)+1);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static class Consumer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				
				while(true){
					System.out.println("Consumer reading"+ buffer.read());
					Thread.sleep((int)(Math.random() * 1000)+1);
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static class Buffer{
		private static final int CAPACITY = 1;
		private LinkedList<Integer> queue = new LinkedList<Integer>();
		
		private static Lock lock = new ReentrantLock();
		
		private static Condition notEmpty = lock.newCondition();
		private static Condition notFull = lock.newCondition();
		
		public void write(int value){
			lock.lock();
			try {
				while(queue.size() == CAPACITY){
					System.out.println("Wait for notFull condition");
					notFull.await();
				}
				
				queue.offer(value);
				notEmpty.signal();
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				lock.unlock();
			}
		}
		
		public int read(){
			lock.lock();
			int value = 0;
			try {
				while(queue.size() != CAPACITY){
					System.out.println("Wait for notEmpty condition");
					notEmpty.await();
				}
				
				value = queue.remove();
				notFull.signal();
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				lock.unlock();
				return value;
			}
		}
	}

}
