package com.leetcode.oj;

import java.util.Arrays;

public class Solution_118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,2};
		int[] result = searchRange(A, 2);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	public static int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
		int index = Arrays.binarySearch(A, target);
        if(index < 0){
        	result[0] = -1;
        	result[1] = -1;
        	return result;
        }
        int begin = index - 1;
        int end = index + 1;
        while(begin >= 0){
        	if(A[begin] != target)
        		break;
        	begin--;
        }
        if(begin < 0)
        	result[0] = 0;
        else
        	result[0] = begin + 1;
        
        while(end < A.length){
        	if(A[end] != target)
        		break;
        	end++;
        }
        if(end == A.length)
        	result[1] = A.length - 1;
        else
        	result[1] = end - 1;;
        return result;
    }
}
