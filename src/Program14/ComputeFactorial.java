package Program14;

import java.util.Scanner;

public class ComputeFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Enter a number:");
		
		int n = inputScanner.nextInt();
		
		System.out.println("Factorial of " + n + " is " + factorial(n));
	}
	
	public static long factorial(int n) {
		if(n ==0)
			return 1;
		else
			return n*factorial(n-1);
	}

}
