package Program13;

import java.util.Scanner;

public class QuotientWithMethod {
	public static int quotient(int number1, int number2){
		if(number2 == 0)
			throw new ArithmeticException("Divisior cannot be zero");
		
		return number1/number2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Enter two integers: ");
		int number1 = inputScanner.nextInt();
		int number2 = inputScanner.nextInt();
		
		try{
			int result = quotient(number1,number2);
			System.out.println(number1 + " / " + number2 + " is " + result);
		}
		catch(ArithmeticException ex){
			System.out.println("Exceprion: ana intefer cannot be divided by zero");
		}
	}

}
