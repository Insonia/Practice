package Program13;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Quotient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Enter two integers: ");
		int number1 = inputScanner.nextInt();
		int number2 = inputScanner.nextInt();
		
		System.out.println(number1 + " / " + number2 + " is " + (number1/number2));
	}

}
