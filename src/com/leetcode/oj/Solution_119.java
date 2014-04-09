package com.leetcode.oj;

public class Solution_119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,0,1,2,3};
		System.out.println(search(A, 5));
	}
	
	public static int search(int[] A, int target) {
        int begin = 0;
        int end = A.length - 1;
        while(begin < end){
        	int mid = (begin + end ) /2;
        	if(A[mid] == target) return mid;
        	if(A[begin] <= A[mid]){
        		if(A[begin] <= target && target < A[mid])
        			end = mid - 1;
        		else
        			begin = mid + 1;
        	}else {
				if(A[mid] < target && target <= A[end])
					begin = mid + 1;
				else
					end = mid - 1;
			}
        }
        if(begin == end && A[begin] == target)
        	return begin;
        else
        	return -1;
    }
}
