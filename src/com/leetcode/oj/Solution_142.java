package com.leetcode.oj;

public class Solution_142 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(1121));
	}
	
	public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int temp = x;
        long res = 0;
        while(x != 0){
        	res = res * 10 + x % 10;
        	x /= 10;
        }
        x = (int)res;
        if(x == temp) return true;
        else return false;
    }

}
