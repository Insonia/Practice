package Program13;

import java.util.Scanner;

public class QuotientWithException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Enter two integers: ");
		int number1 = inputScanner.nextInt();
		int number2 = inputScanner.nextInt();
		
		try {
			if(number2 == 0)
				throw new ArithmeticException("Division cannot be zero");
			System.out.println(number1 + " / " + number2 + " is " + (number1/number2));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: an integer "+ "Cannot be divided by zero");
		}
		//System.out.println(number1 + " / " + number2 + " is " + (number1/number2));
	}

}
