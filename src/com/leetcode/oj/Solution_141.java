package com.leetcode.oj;

public class Solution_141 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isMatch(String s, String p) {
        if(s.length() == 0) return p.length() == 0;
        
        if(p.length() == 1 || p.charAt(1) != '*'){
        	if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
        		return false;
        	return isMatch(s.substring(1), p.substring(1));
        }else {
			int len = s.length();
			int i = -1;
			while(i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
				if(isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
    }
}
