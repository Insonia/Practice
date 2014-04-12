package com.leetcode.oj;

public class Solution_110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}
	
	public static int trap(int[] A) {
        if(A.length < 2)
        	return 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        
        left[0] = A[0];
        for(int i = 1; i < A.length; i++)
        	left[i] = left[i - 1] > A[i] ? left[i - 1] : A[i];
        
        right[A.length - 1] = A[A.length - 1];
        for(int i = A.length - 2; i >= 0; i--)
        	right[i] = right[i + 1] > A[i] ? right[i + 1] : A[i];
        	
        int sum = 0;
        for(int i = 0; i < A.length; i++)
        	sum += (left[i] > right[i] ? right[i] : left[i]) - A[i];
        
        return sum;
    }

}
