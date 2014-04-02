package com.leetcode.oj;

public class Solution_143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int atoi(String str) {
        String[] temp = str.split("\\s+");
        if(temp.length == 0) return 0;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < temp.length; i++)
        	sb.append(temp[i]);
        str = sb.toString();
        char[] chars = str.toCharArray();
        int index = 0;
        boolean positive = true;
        while(chars[index] == '+' || chars[index] == '-'){
        	
        }
    }

}
