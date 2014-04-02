package com.handsome.yin;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TestStringTokenizer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a string:");
		String s = input.nextLine();
		
		StringTokenizer tokens =new  StringTokenizer(s,"(+-/*)",true);
		//System.out.println(tokens.nextToken().trim());
		while(tokens.hasMoreTokens()){
			System.out.println(tokens.nextToken().trim());
		}
	}

}
