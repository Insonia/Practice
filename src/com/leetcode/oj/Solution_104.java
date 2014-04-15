package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_104 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,2};
		ArrayList<ArrayList<Integer>> res = permuteUnique(num);
		for(int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
	}
	
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        permutation(num, 0, num.length, res);
        return res;
    }
	
	public static void permutation(int[] a, int t, int n, ArrayList<ArrayList<Integer>> res) {
		if (t == n) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < n; i++)
				temp.add(a[i]);
			res.add(temp);
			return;
		}

		for (int j = t; j < n; j++) {
			int flag = 1;
			for (int r = t; r < j; r++) {
				if (a[r] == a[j]) {
					flag = 0;
					break;
				}
			}
			if (flag == 0) {
				continue;
			}
			swap(a,j,t);
			permutation(a, t + 1, n,res);
			swap(a,j,t);
		}
	}
	
	private static void swap(int[] a,int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
