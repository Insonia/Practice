package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_134 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1 ,0 ,-1, 0, -2, 2};
		ArrayList<ArrayList<Integer>> result = fourSum(num, 0);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j) + " ");
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        return find(num, 0, 4, target);
    }
	
	public static ArrayList<ArrayList<Integer>> find(int[] num, int begin,int count, int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(count == 3){
			if(num.length - begin > 2){
				for(int i = begin; i < num.length - 2; i++){
					if(i > begin && num[i] == num[i -1]) continue;
					int head = i + 1;
					int tail = num.length - 1;
					while(head < tail){
						if(num[head] + num[tail] + num[i] == target){
							ArrayList<Integer> temp = new ArrayList<Integer>();
							temp.add(num[i]);
							temp.add(num[head]);
							temp.add(num[tail]);
							result.add(temp);
							do {
								head++;
							} while (head < tail && num[head] == num[head -1]);
							do {
								tail--;
							} while (tail > head && num[tail] == num[tail + 1]);
						}else if (num[head] + num[tail] + num[i] < target) {
							head++;
						}else {
							tail--;
						}
					}
				}
			}
		}else {
			for(int i = begin; i < num.length - count + 1; i++){
				if(i > begin && num[i] == num[i -1]) continue;
				ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
				temp = find(num, i + 1, count - 1, target - num[i]);
				if(!temp.isEmpty()){
					for(int j = 0; j< temp.size(); j++){
						temp.get(j).add(0, num[i]);
						result.add(temp.get(j));
					}
				}
			}
		}
		return result;
	}

}
