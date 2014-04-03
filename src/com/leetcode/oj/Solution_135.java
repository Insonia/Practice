package com.leetcode.oj;

import java.util.Arrays;

public class Solution_135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1 ,2 ,1 ,-4};
		System.out.println(threeSumClosest(num, 2));
	}
	
	public static int threeSumClosest(int[] num, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(num);
        
        for(int i = 0; i < num.length - 2; i++){
        	int head = i + 1;
        	int tail = num.length -1;
        	while(head < tail){
        		int sum = num[i] + num[head] + num[tail];
        		int dif = Math.abs(sum - target);
        		if(dif == 0) return target;
        		if(dif < min){
        			min = dif;
        			result = sum;
        		}
        		if(sum < target) head++;
        		if(sum > target) tail--;
        	}
        }
        return result;
    }

}
