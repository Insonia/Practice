package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		int length = intervals.size();
		if(length == 0 || length == 1) return intervals;
		Collections.sort(intervals, new cmp());
		ArrayList<Interval> res = new ArrayList<Interval>();
		Interval temp = intervals.get(0);
		for(int i = 1; i < length; i++){
			Interval itv = intervals.get(i);
			if(temp.end >= itv.start){
				int left = Math.min(temp.start, itv.start);
				int right = Math.max(temp.end, itv.end);
				temp = new Interval(left,right);
			}else {
				res.add(temp);
				temp = itv;
			}
		}
		res.add(temp);
		return res;
	}

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	public static class cmp implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			// TODO Auto-generated method stub
			return o1.start - o2.start;
		}
		
	}

}
