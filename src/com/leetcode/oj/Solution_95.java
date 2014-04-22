package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_95 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
//		intervals.add(new Interval(5,7));
//		intervals.add(new Interval(8,10));
//		intervals.add(new Interval(11,13));
		//intervals.add(new Interval());
		ArrayList<Interval> res = insert(intervals, new Interval(0,5));
		System.out.println(res);
	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		int n = intervals.size();
		if(n == 0) {res.add(newInterval); return res;};
		int index = 0;
		while(index < n){
			if(intervals.get(index).start <= newInterval.start && intervals.get(index).end >= newInterval.start ){
				newInterval.start = intervals.get(index).start;
				newInterval.end = newInterval.end > intervals.get(index).end ? newInterval.end : intervals.get(index).end;
				index++;
				break;
			} else if (intervals.get(index).start > newInterval.start) {
				break;
			}
			else {
				res.add(intervals.get(index));
				index++;
			}
		}
		
		while(index < n){
			if(intervals.get(index).start <= newInterval.end && intervals.get(index).end >= newInterval.end){
				newInterval.end = intervals.get(index).end;
				index++;
				break;
			}else if (intervals.get(index).start > newInterval.end) {
				break;
			}
			else
				index++;
		}
		
		res.add(newInterval);
		
		if(index < n)
			while(index < n){
				res.add(intervals.get(index));
				index++;
			}
		
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

}
