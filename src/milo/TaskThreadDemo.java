package milo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable printA = new PrintChar('a', 1000);
		Runnable printB = new PrintChar('b', 1000);
		Runnable print100 = new PrintNum(100);
		
//		Thread thread1 = new Thread(printA);
//		Thread thread2 = new Thread(printB);
//		Thread thread3 = new Thread(print100);
//		
//		thread1.start();
//		thread2.start();
//		thread3.start();
		
		ExecutorService excutor = Executors.newFixedThreadPool(3);
		
		excutor.execute(printA);
		excutor.execute(printB);
		excutor.execute(print100);
		
		excutor.shutdown();
	}

}

class PrintChar implements Runnable{
	private char charToPoint;
	private int times;
	
	public PrintChar(char c, int times){
		this.charToPoint = c;
		this.times = times;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < times; i++)
			System.out.print(charToPoint);
	}
	
}

class PrintNum implements Runnable{
	private int lastNum;
	
	public PrintNum(int n){
		lastNum = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			for(int i = 1; i <= lastNum;i ++){
			System.out.print(" " + i);
			//Thread.yield();
			if(i>50) Thread.sleep(1);
			}
		}catch(Exception e){
			
		}
		
	}
	
}
