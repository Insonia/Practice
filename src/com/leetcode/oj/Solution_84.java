package com.leetcode.oj;

public class Solution_84 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = {8,9};
		int[] res = plusOne(digits);
		for(int i = 0; i < res.length; i++)
			System.out.print(res[i]);
	}
	
	public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry = 0;
        if(++digits[--length] < 10)
    		return digits;
        else{
        	carry = 1;
        	digits[length] = 0;
        }
        while(length > 0){
        	if(digits[--length] + carry < 10){
        		digits[length] = digits[length] + carry;
        		return digits;
        	}
        	else
        		digits[length] = digits[length] + carry - 10;
        }
        
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for(int i = 1; i < res.length; i++)
        	res[i] = 0;
        return res;
    }

}
