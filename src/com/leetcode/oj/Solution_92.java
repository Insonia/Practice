package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_92 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(3, 2));
	}
	
	public static String getPermutation(int n, int k) {
        ArrayList<Integer> number = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
        	number.add(i);
        
        k--;
        
        int mod = 1;
        for(int i = 1; i <= n; i++)
        	mod *= i;
        
        String result = "";
        
        for(int i = 0; i < n; i++){
        	mod = mod / (n - i);
        	
        	int current = k / mod;
        	
        	k = k % mod;
        	
        	result += number.get(current);
        	number.remove(current);
        }
        
        return result;
    }
}
