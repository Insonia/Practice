package Program13;

import java.util.Scanner;

public class QuotientWithIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Enter two integers: ");
		int number1 = inputScanner.nextInt();
		int number2 = inputScanner.nextInt();
		
		if(number2 == 0)
			System.out.println("Division cannot be zero!");
		else
			System.out.println(number1 + " / " + number2 + " is " + (number1/number2));
	}

}
