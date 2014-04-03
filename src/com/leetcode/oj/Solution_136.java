package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long strat = System.currentTimeMillis();
		int[] num = {0,0,0,0};
		ArrayList<ArrayList<Integer>> result = threeSum(num);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j) + " ");
			System.out.println();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - strat);
	}
	
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num.length < 3) return result;
		Arrays.sort(num);
		for(int i = 0; i< num.length - 2 && num[i] <= 0; i++){
			int head = i + 1;
			int tail = num.length - 1;
			if( i > 0 && num[i] == num[i - 1]) continue;//去重
			while(head < tail){
				if(num[head] + num[tail] + num[i] == 0){
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(num[i]);
					temp.add(num[head]);
					temp.add(num[tail]);
					result.add(temp);
					//去重
					do {
						head++;
					} while (head < tail && num[head] == num[head -1]);
					do {
						tail--;
					} while (tail > head && num[tail] == num[tail + 1]);
				}else if (num[head] + num[tail] + num[i] < 0) {
					head++;
				}else {
					tail--;
				}
			}
		}
		return result;
    }

}
