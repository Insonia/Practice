package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("23"));
	}
	
	public static ArrayList<String> letterCombinations(String digits) {
		String[] ss = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		
		ArrayList<String> result = new ArrayList<String>();
		DFS(result, digits.length(), ss, digits, new StringBuffer());
        return result;
    }
	
	public static void DFS(ArrayList<String> result, int remain, String[] ss,String digitals,StringBuffer sb){
		if(remain == 0){
			result.add(sb.toString());
			return;
		}
		
		String s = ss[digitals.charAt(0) - '0'];
		
		for(int i = 0; i < s.length(); i++){
			sb.append(s.charAt(i));
			DFS(result, remain - 1, ss, digitals.substring(1), sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
