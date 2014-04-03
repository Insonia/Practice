package com.leetcode.oj;

public class Solution_138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("IV"));
	}
	
	public static int romanToInt(String s) {
        if(s.length() == 0) return 0;
        s = s.toUpperCase();
        if(s.length() == 1) return getInt(s.charAt(0));
        int index = 0;
        int result = 0;
        while(index < s.length() - 1){
        	int nxt = getInt(s.charAt(index + 1));
        	int cur = getInt(s.charAt(index));
        	if(nxt > cur){
        		result += nxt - cur;
        		index += 2;
        	}
        	else{
        		result += cur;
        		index++;
        	}
        }
        if(index == s.length() - 1) result += getInt(s.charAt(s.length() - 1));
        return result;
    }
	
	public static int getInt(char c){
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}
}
