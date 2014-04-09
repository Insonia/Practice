package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {10,1,2,7,6,1,5};
		ArrayList<ArrayList<Integer>> res = combinationSum(candidates, 8);
		System.out.println(res);
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0)
        	return res;
        Arrays.sort(candidates); //����
        helper(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
	
	public static void helper(int[] candidates, int start,int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
		if(target < 0)
			return;
		if(target == 0){
			res.add(new ArrayList<Integer>(item)); //ע�⣬��Ҫnewһ������Ϊitem���
			return;
		}
		for(int i = start; i < candidates.length; i++){
			if(i > start && candidates[i] == candidates[i - 1])
				continue;
			item.add(candidates[i]);
			helper(candidates, i + 1, target - candidates[i], item, res);
			item.remove(item.size() - 1);
		}
	}
}
