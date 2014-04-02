package HelloWorld;

import java.util.Scanner;

public class AdditionQuize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = (int)(System.currentTimeMillis()%10);
		int number2 = (int)(System.currentTimeMillis()%7%10);
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is " + number1 + "+" + number2);
		
		int answer = input.nextInt();
		
		if(answer == (number1+number2))
		{
			System.out.println("Right!");
		}else {
			System.out.println("Wrong!");
		}
	}

}
