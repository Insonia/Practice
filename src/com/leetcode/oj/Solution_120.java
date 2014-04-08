package com.leetcode.oj;

import java.util.Stack;

public class Solution_120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestValidParentheses("()(()()"));
	}
	
	public static int longestValidParentheses(String s) {
        int maxLength = 0;
        int last = -1;
        Stack<Integer> left = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == '(')
        		left.push(i);
        	else {
				if(left.isEmpty())
					last = i;
				else {
					left.pop();
					if(left.isEmpty())
						maxLength = maxLength > i - last? maxLength : i - last;
					else
						maxLength = maxLength > i - left.peek()? maxLength : i - left.peek();
				}
			}
        }
        return maxLength;
    }

}
