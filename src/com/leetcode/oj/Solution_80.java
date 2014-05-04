package com.leetcode.oj;

import java.util.LinkedList;

public class Solution_80 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/asd/../asdasd//asf"));
	}
	
	public static String simplifyPath(String path) {
        if(path.length() == 0)
        	return path;
        LinkedList<String> stack = new LinkedList<String>();
        String[] strings = path.split("/");
        for(String s : strings){
        	if(s.equals(".") || s.length() == 0)
        		continue;
        	else if (s.equals("..")) {
				if(!stack.isEmpty())
					stack.pop();
			}else
				stack.push(s);
        }
        if(stack.isEmpty())
        	stack.push("");
        String res = "";
        while(!stack.isEmpty())
        	res += "/" + stack.removeLast();
        
        return res;
    }
}
