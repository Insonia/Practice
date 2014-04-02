package com.leetcode.oj;

public class Solution_143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoi("   ++0 123"));
	}
	
	public static int atoi(String str) {
        str = str.trim();
        int length = str.length();
        if(length == 0) return 0;
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        int index = 0;
        boolean positive = true;
        if(chars[index] == '+' || chars[index] == '-')
        {
        	if(chars[index] == '-')
        		positive = !positive;
        	index++;
        }
        while((index < length) && chars[index] == '0')
        	index++;
        while((index < length) && chars[index] >= '0' && chars[index] <= '9'){
        	sb.append(chars[index]);
        	index++;
        }
        if(sb.length() < 1) return 0;
        if(!positive) sb.insert(0, '-');
        long l = Long.parseLong(sb.toString());
        if(l > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)l;
    }

}
