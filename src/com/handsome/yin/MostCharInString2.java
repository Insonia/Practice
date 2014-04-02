package com.handsome.yin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MostCharInString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a String:");
		String s = input.next();
		doString(s);
	}
	
	public static void doString(String input){
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		char[] chars = input.toCharArray();
		for(int i = 0; i< chars.length; i++){
			if(!hashMap.containsKey(chars[i]))
				hashMap.put(chars[i], 1);
			else {
				int value = hashMap.get(chars[i]).intValue();
				value++;
				hashMap.put(chars[i], value);
			}
		}
		
		int max = 1;
		Set<Map.Entry<Character, Integer>> set = hashMap.entrySet();
		for(Map.Entry<Character, Integer> entry : set)
			if(entry.getValue() > max)
				max = entry.getValue();
		System.out.println("max: " + max);
		for(Map.Entry<Character, Integer> entry : set)
			if(entry.getValue() == max)
				System.out.print(entry.getKey() + " ");
	}

}
