package HelloWorld;

import java.util.Scanner;

public class E3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		
		System.out.println("Enter a b c: ");
		
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		double delt = Math.pow(b*b - 4*a*c,0.5);
		if(delt < 0)
			System.out.print("No real roots");
		else if(delt == 0)
			System.out.println("Root: " + (-b/2)/a);
		else {
			System.out.println("Root1: "+ ((-b+delt)/2)/a);
			System.out.println("Root2: "+ ((-b-delt)/2)/a);
		}
	}

}
