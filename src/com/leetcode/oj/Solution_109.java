package com.leetcode.oj;

public class Solution_109 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String multiply(String num1, String num2) {
        num1 = (new StringBuffer(num1)).reverse().toString();
        num2 = (new StringBuffer(num2)).reverse().toString();
        
        char[] d = new char[num1.length() + num2.length()];
        for(int i = 0; i < num1.length(); i++)
        	for(int j = 0; j< num2.length(); j++)
        		d[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < d.length; i++){
        	int digit = d[i]%10;
        	int carry = d[i]/10;
        	if(i + 1 < d.length) d[i + 1]+= carry;
        	sb.insert(0, digit);
        }
        while(sb.charAt(0) == '0' && sb.length() > 1)
        	sb.deleteCharAt(0);
        
        return sb.toString();
        
    }

}
