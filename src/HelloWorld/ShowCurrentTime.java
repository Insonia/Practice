package HelloWorld;

import java.util.Scanner;

public class ShowCurrentTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		long totalMilliSeconds = System.currentTimeMillis();
		
		long totalSecond = totalMilliSeconds/1000;
		
		long currentSecond = totalSecond%60;
		
		long totalMinute = totalSecond/60;
		
		long currentMinute = totalMinute%60;
		
		long totalHour = totalMinute/60;
		
		long currentHour = totalHour%24;
		
		System.out.println("Enter:");
		
		int delt = input.nextInt();
		
		System.out.println("Current time is: " + currentHour + ":" + currentMinute + ":" 
				+ currentSecond + "GMT");
		
		//currentHour += delt;
		
		System.out.println("Beijing time is: " + (currentHour+delt) + ":" + currentMinute + ":" 
				+ currentSecond);
	}

}
