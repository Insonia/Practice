package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution_102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"abc","cba","aaa","aas","saa"};
		System.out.println(anagrams(strs));
	}
	
	public static ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for(int i = 0; i < strs.length; i++){
        	String s = sort(strs[i]);
        	if(map.containsKey(s)){
        		ArrayList<Integer> val = map.get(s);
        		val.add(i);
        		map.put(s, val);
        	}else {
				ArrayList<Integer> val = new ArrayList<Integer>();
				val.add(i);
				map.put(s, val);
			}
        }
        
        Set<Map.Entry<String, ArrayList<Integer>>> set = map.entrySet();
        for(Map.Entry<String, ArrayList<Integer>> entry : set){
        	if(entry.getValue().size() > 1)
        		for(int i = 0; i < entry.getValue().size(); i++){
        			int index = entry.getValue().get(i);
        			res.add(strs[index]);
        		}
        }
        
        return res;
    }
	
	public static String sort(String s){
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

}
