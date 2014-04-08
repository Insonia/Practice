package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] L = {"foo","bar","man"};
		System.out.println(findSubstring("barfoothefoobarman", L));
	}
	
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int wLength = L[0].length();
        int lLength = L.length;
        int length = wLength * lLength;
        if(S.length() < length) return result;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> cur = new HashMap<String, Integer>();
        for(String word : L){
        	if(map.containsKey(word))
        		map.put(word, map.get(word)+1);
        	else
        		map.put(word, 1);
        }
        for(int i = 0; i <= S.length() - length; i++){
        	cur = (HashMap<String, Integer>) map.clone();
        	String subString = S.substring(i,length + i);
        	while(true){
        		String word = subString.substring(0, wLength);
        		if(cur.containsKey(word)){
        			int num = cur.get(word) - 1;
        			if(num < 0)
        				break;
        			cur.put(word, num);
        			subString = subString.substring(wLength);
        			if(subString.isEmpty()){
        				result.add(i);
        				break;
        			}        			
        		}
        		else {
					break;
				}
        	}
        }
        return result;
    }

}
