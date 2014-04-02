package com.leetcode.oj;

public class Solution_1 {
	public static void main(String args[]) {
		String string = "   ";
		System.out.println(reverseWords(string));
	}

	public static String reverseWords(String s) {
		String[] strings = s.trim().split("\\s+");
		StringBuffer sb = new StringBuffer();
		String result;
		for (int i = strings.length - 1; i >= 0; i--) {
			sb.append(strings[i]);
			if (i != 0)
				sb.append(" ");
		}
		result = sb.toString();
		return result;
	}
}
