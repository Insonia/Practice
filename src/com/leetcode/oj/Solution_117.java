package com.leetcode.oj;

import java.util.Arrays;

public class Solution_117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4};
		System.out.println(searchInsert(A, 0));
	}
	
	public static int searchInsert(int[] A, int target) {
        int index = Arrays.binarySearch(A, target);
        if(index < 0) return -index - 1;
        else return index;
    }
}
