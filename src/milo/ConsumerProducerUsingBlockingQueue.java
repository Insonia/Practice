package milo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducerUsingBlockingQueue {
	private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(5);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Consumer());
		executor.execute(new Producer());
		
		executor.shutdown();
	}
	
	private static class Consumer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				//int i= 1;
				while(true){
					System.out.println("\t\tConsumer reads " + buffer.take());
					Thread.sleep((int)(Math.random() * 3000));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	private static class Producer implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				int i = 0;
				while(true){
					System.out.println("Producer writes " + i);;
					buffer.put(i++);
					Thread.sleep((int)(Math.random() * 300));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

}
