package com.leetcode.oj;

public class Solution_144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1000000003));
	}
	
	public static int reverse(int x) {
        long res = 0;
        while(x != 0){
        	res = res * 10 + x % 10;
        	x /= 10;
        }
        return (int)res;
    }
}
