package Program13;

import java.util.Scanner;

public class ComputeFabonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Enter an index for the Fibonacci number: ");
		int n = inputScanner.nextInt();
		
		System.out.println("Fiboncci numbet at index " + n + " is " + fib(n));
	}
	
	public static long fib(long index) {
		if(index == 0)
			return 0;
		else if (index == 1) {
			return 1;
		}else {
			return fib(index - 1) + fib(index - 2);
		}
	}

}
