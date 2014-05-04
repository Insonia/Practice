package com.leetcode.oj;

public class Solution_82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(3));
	}
	
	//Å£¶Ùµü´ú·¨
	public static int sqrt(int x) {
        if(x == 0) return 0;
        double last = 0;
        double res = 1;
        while(res != last){
        	last = res;
        	res = (res + x / res) / 2;
        }
        return (int)(res);
    }

}
