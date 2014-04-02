package com.leetcode.oj;

public class Solution_140 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxArea(int[] height) {
//        ³¬Ê±
		//int maxArea = 0;
//        for(int i = 0; i < height.length; i++)
//        	for(int j = i + 1; j < height.length; j++){
//        		int area = (height[i] < height[j] ? height[j] : height[i]) * (j - i);
//        		maxArea = maxArea < area? area : maxArea;
//        	}
//        return maxArea;
		
		long start = System.currentTimeMillis();
		int size = height.length;
		int left = 0;
		int right = size - 1;
		int max = 0;
		while(left < right){
			int temp = (right - left) * Math.min(height[left], height[right]);
			if(max < temp)
				max = temp;
			if(height[left] < height[right]) left++;
			else right--;
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return max;
    }

}
