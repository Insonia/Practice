package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		
		System.err.println(wordBreak("catsanddog", dict));
	}
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if(s.length() < 1 || dict.size() == 0) return result;
        Iterator<String> it = dict.iterator();
        int max = it.next().length();
        int min = max;
        while(it.hasNext()){
        	String temp = it.next();
        	if(temp.length() > max)
        		max = temp.length();
        	if(temp.length() < min)
        		min = temp.length();
        }
        Set<String> unmatch = new HashSet<String>();
        ArrayList<String> path = new ArrayList<String>();
        wordBreakHelper(s, dict, unmatch, min, max, path, result);
        return result;
    }

	public static void wordBreakHelper(String s, Set<String> dict, Set<String> unmatch, int min, int max,
			ArrayList<String> path, ArrayList<String> result){
		int i = max < s.length()? max : s.length();
		for(; i >= min ; i--){
			String preffix = s.substring(0,i);
			if(dict.contains(preffix)){
				path.add(preffix);
				if(preffix.length() == s.length()){
					String temp = path.get(0);
					for(int j = 1; j < path.size(); j++){
						temp += " " + path.get(j);
					}
					result.add(temp);
				}
				String suffix = s.substring(i);
				if(!unmatch.contains(suffix)){
					int oldsz = result.size();
					wordBreakHelper(suffix, dict, unmatch, min, max, path, result);
					if(result.size() == oldsz)
						unmatch.add(suffix);
				}
				path.remove(0);
			}
		}
	}

}
