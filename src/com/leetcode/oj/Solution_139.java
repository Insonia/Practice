package com.leetcode.oj;

import java.util.Arrays;

public class Solution_139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(1111));
	}
	
	public static String intToRoman(int num) {
        char[] symbols = {'I','V','X','L','C','D','M'};
        String roman = "";
        int scale = 1000;
        int p = 6;
        while(num != 0){
        	int bit = num / scale;
        	char[] temp = new char[7];
        	if(p < 0) p =0;
        	System.arraycopy(symbols, p, temp, 0, symbols.length - p);
        	roman = romanStr(roman, bit, temp);
        	num %= scale;
        	scale /= 10;
        	p -= 2;
        }
        return roman;
    }
	
	public static String romanStr(String str, int num, char[] symbols){
		if( num == 0) return str;
		else if(num <=3 ){
			for( int i = 0 ; i < num; i++)
				str += symbols[0];
		}else if (num == 4) {
			str += symbols[0];
			str += symbols[1];
		}else if (num <= 8) {
			str += symbols[1];
			for(int i = 0; i< num - 5; i++)
				str += symbols[0];
		}else{
			str += symbols[0];
			str += symbols[2];
		}
		
		return str;
	}

}
