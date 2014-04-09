package com.leetcode.oj;

//题意是n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；n=3时，
//由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211。

public class Solution_114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(6));
	}
	
	public static String countAndSay(int n) {
		if(n == 1){  
            return "1";  
        }  
          
        String s = "1";  
        StringBuffer ret = new StringBuffer();  
        int cnt = 0;  
        int round = 0;          // round是迭代多少次  
        int i;  
        while(++round < n){  
            cnt = 1;  
            ret.setLength(0);  
            for(i=1; i<s.length(); i++){  
                if(s.charAt(i) == s.charAt(i-1)){       // 重复的值，继续计数  
                    cnt++;  
                }else{          // 有新的值出现，记录到ret  
                    ret.append(cnt).append(s.charAt(i-1));  
                    cnt = 1;        // 重置cnt  
                }  
            }  
            ret.append(cnt).append(s.charAt(i-1));  
            s = ret.toString(); // 更新s  
        }  
        return ret.toString();  
    }

}
