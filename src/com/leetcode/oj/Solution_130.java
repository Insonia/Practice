package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result = generateParenthesis(3);
		System.out.println(result);
	}
	
	public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        String s = "";
        generator(n, n, s, result);
        return result;
    }
	
	public static void generator(int leftNum, int rightNum, String s, ArrayList<String> result){
		if(leftNum == 0 && rightNum ==0)
			result.add(s);
		if(leftNum > 0)
			generator(leftNum - 1, rightNum, s + "(", result);
		if(rightNum > 0 && rightNum > leftNum)
			generator(leftNum, rightNum - 1, s + ")", result);
	}

}
