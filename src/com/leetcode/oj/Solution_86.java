package com.leetcode.oj;

public class Solution_86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addBinary("11", "11"));
	}
	
	public static String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        
        if(aLength == 0) return b;
        if(bLength == 0) return a;
        
        int carry = 0;
        int sum = 0;  
        int aValue = 0;
        int bValue = 0;
        StringBuffer sb = new StringBuffer();
        
        while(aLength > 0 && bLength > 0){
        	aValue = Integer.parseInt(a.charAt(--aLength)+"");
        	bValue = Integer.parseInt(b.charAt(--bLength)+"");
        	sum = aValue + bValue + carry;
        	switch (sum) {
			case 0:
			case 1:
				carry = 0;
				sb.insert(0, sum);
				break;
			case 2:
				carry = 1;
				sb.insert(0, 0);
				break;
			case 3:
				carry = 1;
				sb.insert(0, 1);
				break;
			default:
				break;
			}
        }
        
        while(aLength > 0){
        	sum = carry + Integer.parseInt(a.charAt(--aLength)+"");
        	if(sum == 0 || sum == 1){
        		carry = 0;
        		sb.insert(0, sum);
        	}else {
				carry = 1;
				sb.insert(0, 0);
			}
        }
        
        while(bLength > 0){
        	sum = carry + Integer.parseInt(b.charAt(--bLength)+"");
        	if(sum == 0 || sum == 1){
        		carry = 0;
        		sb.insert(0, sum);
        	}else {
				carry = 1;
				sb.insert(0, 0);
			}
        }
        if(carry == 0)
        	return sb.toString();
        else{
        	sb.insert(0, 1);
        	return sb.toString();
        }
    }

}
