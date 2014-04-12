package com.leetcode.oj;

public class Solution_111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,4,5,2,4,2,5,6,7};
		System.out.println(firstMissingPositive(A));
	}
	
	public static int firstMissingPositive(int[] A) {
        int n = A.length;
        int i = 0;
        while(i < n){
        	if(A[i] != i + 1 && A[i] >= 1 && A[i] <= n && A[A[i] - 1] != A[i])
        		swap(A, i, A[i] - 1);
        	else
        		i++;
        }
        for(i = 0; i < n; i++)
        	if(A[i] != i + 1)
        		return i + 1;
        return n + 1;
    }
	
	public static void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
