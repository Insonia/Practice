package com.handsome.yin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class MostCharInString1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Input a string:");
		String s = input.nextLine();
		doString(s);
	}
	
	public static void doString(String input){
		char[] chars = input.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		TreeSet<String> set = new TreeSet<String>();
		for(int i = 0; i < chars.length; i++){
			list.add(String.valueOf(chars[i]));
			set.add(String.valueOf(chars[i]));
		}
		System.out.println(set);
		Collections.sort(list);
		System.out.println(list);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < list.size(); i++)
			sb.append(list.get(i));
		
		input = sb.toString();
		System.out.println(input);
		int max = 0;
		String maxString = "";
		ArrayList<String> maxList = new ArrayList<String>();
		
		Iterator<String> its = set.iterator();
		while(its.hasNext()){
			String os = (String)its.next();
			int begin = input.indexOf(os);
			int end = input.lastIndexOf(os);
			int value = end - begin + 1;
			if(value > max){
				max = value;
				maxString = os;
				maxList.add(os);
			}else if(value == max) {
				maxList.add(os);
			}
		}
		
		int index = 0;
		for(int i = 0; i < maxList.size(); i++){
			if(maxList.get(i).equals(maxString)){
				index = i;
				break;
			}
		}
		System.out.print("Max data:");
		for(int i = index ;i < maxList.size(); i++){
			System.out.print(maxList.get(i) + " ");
		}
		System.out.println();
		System.out.println("max: " + max);
	}

}
