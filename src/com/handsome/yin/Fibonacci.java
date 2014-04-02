package com.handsome.yin;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter n(n>=2):");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(fabonacci(n));
	}
	
	public static int fabonacci(int n){
		if(n == 1 || n == 2)
			return 1;
		else{
			return fabonacci( n -1 ) + fabonacci(n - 2);
		}
	}

}
