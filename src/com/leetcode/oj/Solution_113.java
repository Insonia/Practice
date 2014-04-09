package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,2,3,6,7};
		ArrayList<ArrayList<Integer>> res = combinationSum(candidates, 7);
		System.out.println(res);
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0)
        	return res;
        Arrays.sort(candidates); //排序
        helper(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
	
	public static void helper(int[] candidates, int start,int target, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
		if(target < 0)
			return;
		if(target == 0){
			res.add(new ArrayList<Integer>(item)); //注意，需要new一个，因为item会变
			return;
		}
		for(int i = start; i < candidates.length; i++){
			if(i > 0 && candidates[i] == candidates[i - 1])
				continue;
			item.add(candidates[i]);
			helper(candidates, i, target - candidates[i], item, res);
			item.remove(item.size() - 1);
		}
	}

}
