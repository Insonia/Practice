package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution_150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3,2,4};
		int target = 6;
		int[] result = twoSum(numbers, target);
		System.out.println(result[0] + "" + result[1] + "");
	}
	
public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers.length < 2) return result;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++)
        	map.put(numbers[i], i);
        for( int i= 0; i < numbers.length; i++){
        	if(map.containsKey(target - numbers[i])){
        		int val = map.get(target - numbers[i]);
        		if( i == val) continue;
        		result[0] = ((i + 1) > (val + 1)) ? val + 1 : i + 1;
        		result[1] = ((i + 1) < (val + 1)) ? val + 1 : i + 1;
        		break;
        	}
        }
        return result;
    }
}
