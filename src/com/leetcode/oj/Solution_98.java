package com.leetcode.oj;

public class Solution_98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,1,2,-1,-2,-3,7,8};
		System.out.println(maxSubArray(A));
	}
	
	public static int maxSubArray(int[] A) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
        	if(ans < 0) ans = 0;
        	ans += A[i];
        	max = max > ans? max : ans;
        }
        return max;
    }

}
