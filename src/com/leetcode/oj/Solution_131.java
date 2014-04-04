package com.leetcode.oj;

public class Solution_131 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("{}[]("));
	}
	
	public static boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(s.length() == 1) return false;
        StringBuffer sb = new StringBuffer();
        sb.append(s.charAt(0));
        int index = 0;
        for(int i = 1; i < s.length(); i++){
        	if(index < 0){
        		sb.append(s.charAt(i));
				index++;
        	}
        	else if(isMathc(sb.charAt(index), s.charAt(i))){
        		sb.deleteCharAt(index);
        		index--;
        	}
        	else {
				sb.append(s.charAt(i));
				index++;
			}
        }
        if(sb.length() == 0) return true;
        else return false;
    }
	
	public static boolean isMathc(char c1, char c2) {
		if(c1 == '(' && c2 ==')')
			return true;
		if(c1 == '{' && c2 == '}')
			return true;
		if(c1 == '[' && c2 == ']')
			return true;
		return false;
	}

}
