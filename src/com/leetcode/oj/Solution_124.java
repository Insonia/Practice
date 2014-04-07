package com.leetcode.oj;

public class Solution_124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("", ""));
	}
	
	public static String strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return null;
        int hLength = haystack.length();
        int nLength = needle.length();
        if(nLength < 1) return haystack;
        if(hLength < nLength) return null;
        for(int i = 0; i <= hLength - nLength; i++){
        	if(haystack.charAt(i) == needle.charAt(0)){
        		int j = 0;
        		for(; j < nLength; j++){
        			if(haystack.charAt(i + j) != needle.charAt(j))
        				break;
        		}
        		if( j == nLength) return haystack.substring(i);
        	}
        }
        return null;
    }

}
