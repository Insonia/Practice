package HelloWorld;

import java.util.Scanner;

public class ComputeAreaWithConsoleInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number:");
		double radius = input.nextDouble();
		
		double area = radius*radius*3.14;
		
		System.out.println("The area is: " + area);
	}

}
