package com.leetcode.oj;

public class Solution_85 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isNumber(String s) {
		if(s.trim().isEmpty()){  
            return false;  
        }  
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
        if(s.trim().matches(regex)){  
            return true;  
        }else{  
            return false;  
        }  
    }

}
