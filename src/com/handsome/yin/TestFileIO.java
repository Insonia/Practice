package com.handsome.yin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestFileIO {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("yin.txt");
//		PrintWriter output = new PrintWriter(file);
//		output.print(1);
//		output.print(" ");
//		output.print(true);
//		output.print(" ");
//		output.print(2);
//		
//		output.close();
		
		Scanner input = new Scanner(file);
		int j = input.nextInt();
		//String s = input.next();
		boolean b = input.nextBoolean();
		int i = input.nextInt();
		System.out.println(b);
		System.out.println(i);
	}

}
