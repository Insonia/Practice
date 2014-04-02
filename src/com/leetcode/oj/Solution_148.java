package com.leetcode.oj;

public class Solution_148 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "aaaaaaa";
		System.out.println(lengthOfLongestSubstring(string));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int max = 1;
        for(int i = 0; i < s.length(); i++){
        	StringBuilder longestStr = new StringBuilder();
        	longestStr.append(s.charAt(i));
        	for(int j = i + 1; j < s.length(); j++){
        		if (isOccurred(longestStr, s.charAt(j))) {
					break;
				}else {
					longestStr.append(s.charAt(j));
				}
        	}
        	if( longestStr.length() > max) max = longestStr.length();
        }
        return max;
    }
	
	public static boolean isOccurred(StringBuilder sb, char c){
		String s = sb.toString();
		int index = s.indexOf(c);
		if(index == -1) return false;
		else return true;
	}

}
