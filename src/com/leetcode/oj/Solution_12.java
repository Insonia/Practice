package com.leetcode.oj;

import java.util.HashSet;
import java.util.Set;

public class Solution_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("aa");
		dict.add("aaaa");
		System.out.println(wordBreak("aaaaaaa", dict));
	}
	
	public static boolean wordBreakHelper(String s, Set<String> dict, Set<String> unmatch){
		if(s.length() < 1) return true;
		boolean flag = false;
		for(int i = 1; i <= s.length(); i++){
			String prefixString = s.substring(0, i);
			if(dict.contains(prefixString)){
				String suffixString = s.substring(i);
				if(unmatch.contains(suffixString)) continue;
				else {
					flag = wordBreakHelper(suffixString, dict, unmatch);
					if(flag) return true;
					unmatch.add(suffixString);
				}
			}
		}	
		return false;
	}
	
	public static boolean wordBreak(String s, Set<String> dict) {
        if(s.length() < 1) return true;
        Set<String> unmatch = new HashSet<String>();
        return wordBreakHelper(s, dict, unmatch);
    }
}
