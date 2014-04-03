package com.leetcode.oj;

public class Solution_137 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"aaab","aaabb","aaaaa"};
		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int strlength = strs[0].length();
        for(int row = 1; row < strs.length; row++)
        	if(strs[row].length() < strlength)
        		strlength = strs[row].length();
        int count = 0;
        boolean flag = true;
        char common;
		for(int i = 0; i < strlength; i++){
        	common = strs[0].charAt(i);
        	int row = 1;
        	for( ;row < strs.length; row++){
        		if(strs[row].charAt(i) != common){
        			flag = false;
        			break;
        		}
        	}
        	if(row == strs.length && flag == true) count++;
        }
		return strs[0].substring(0, count);
    }
}
