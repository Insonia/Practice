package HelloWorld;

import java.util.Scanner;

public class ComputeAverage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		double d1 = input.nextDouble();
		double d2 = input.nextDouble();
		double d3 = input.nextDouble();
		
		double d = (d1+d2+d3)/3;
		System.out.println(d);
	}

}
