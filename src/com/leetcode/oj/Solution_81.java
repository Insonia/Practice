package com.leetcode.oj;

public class Solution_81 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(44));
	}

	public static int climbStairs(int n) {
       // return helper(n);
		
		//动态规划填表法
		if(n == 1) return 1;
		if(n == 2) return 2;
		int[] res = new int[n];
		res[0] = 1;
		res[1] = 2;
		for(int i = 2; i < n; i++)
			res[i] = res[i - 1] + res[i - 2];
		return res[n-1];
    }
	
//递归重复计算，超时	
//	public static int helper(int n){
//		if(n == 1) return 1;
//        if(n == 2) return 2;
//        int res = helper(n-1)+helper(n-2);
//        return res;
//	}
}
