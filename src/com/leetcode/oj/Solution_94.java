package com.leetcode.oj;

public class Solution_94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("a    d   asd"));
	}
	
	//kadenseÀ„∑®
	public static int lengthOfLastWord(String s) {
        int count = 0;
        if(s.length() == 0) return count;
        if(s.charAt(0) != ' ') count = 1;
        if(s.length() == 1) return count;
        for(int i = 1; i < s.length(); i++){
        	if(s.charAt(i) != ' '){
        		if(s.charAt(i - 1) != ' ')
        			count++;
        		else
        			count = 1;
        	}
        }
        return count;
    }

}
