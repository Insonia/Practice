package com.leetcode.oj;

public class Solution_146 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("aaabaa"));
	}
	
	public static String longestPalindrome(String s) {
        char[] c = new char[2003];
        int[] p = new int[2003];
        int sSize = s.length();
        int sLength = 0;
        c[sLength++] = '$';
        for(int i = 0; i < sSize; i++){
        	c[sLength++] = '#';
        	c[sLength++] = s.charAt(i); 
        }
        c[sLength] = '#';
        
        int id = 0;
        int max = 0;
        for(int i = 1; i < sLength; i++){
        	if(max > i)
        		p[i] = (p[2 * id - i] > max - i) ? max - i : p[2 * id - i];
        	else
        		p[i] = 1;
        	while(c[i - p[i]] == c[i + p[i]])
        		++p[i];
        	if(i + p[i] > max){max = i + p[i]; id = i;}
        }
        
        max = 1;
        for( int i = 1; i < sLength; i++){
        	if(p[i] > max){
        		max = p[i];
        		id = i;
        	}
        }
        --max;
        return s.substring((id - max + 1)/2 - 1, (max + id + 1) / 2 -1);
    }

}
