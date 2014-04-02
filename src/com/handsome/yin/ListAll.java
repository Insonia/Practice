package com.handsome.yin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of Strings: ");
		int n = input.nextInt();
		System.out.println("Enter numbers:");
		String[] array = new String[n];
		for(int i = 0; i< n; i++){
			int s = input.nextInt();
			array[i] = s + "";
		}
		listAll(Arrays.asList(array), "");	
	}
	
	public static void listAll(List list, String prefix){
		if(list.isEmpty())
			System.out.println(prefix);
		
		for(int i = 0; i < list.size(); i++){
			List temp = new LinkedList(list);
			listAll(temp, prefix + temp.remove(i));
		}
	}

}
