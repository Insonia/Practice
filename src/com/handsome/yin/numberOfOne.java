package com.handsome.yin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class numberOfOne {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		PrintWriter output = new PrintWriter(new File("yin.txt"));
		int n = 2;
		int res = 1;
		while(getOnly(n) + res != n){
			res += getOnly(n);
			output.print("f(");
			output.print(n);
			output.print(")=");
			output.println(res);
			//Thread.sleep(2);
			n++;
		}
		System.out.println(n);
	}
	
	public static int getOnly(int n){
		int number = 0;
		String s = n + "";
		int l = s.length();
		for(int i = 0 ; i < l ; i++){
			if(s.charAt(i) == '1')
				number++;
		}
		return number;
	}

}
