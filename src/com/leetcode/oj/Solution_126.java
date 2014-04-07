package com.leetcode.oj;

import java.util.Arrays;

public class Solution_126 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,2,2,2,3,4};
		System.out.println(removeDuplicates(A));
		for(int i = 0; i< A.length;i++)
			System.out.println(A[i]);
	}
	
	public static int removeDuplicates(int[] A) {
//        if(A.length < 2) return A.length;
//        int temp = A[0];
//        int count = 0;
//        boolean flag = true;
//        for(int i = 1; i< A.length; i++){
//        	if(A[i] == temp){
//        		count++;
//        		if(flag){
//        			count++;
//        			flag = false;
//        		}
//        	}else{
//        		temp = A[i];
//        		flag = true;
//        	}
//        }
//        return count;
		int n = A.length;
		if(n < 1) return 0;  
        int index = 0;  
        int pre = 1;  
        while(pre < n){  
            if(A[pre] == A[index]) pre++;  
            else{  
                if(pre - index == 1){pre++; index++;}  
                else A[++index] = A[pre++];  
            }              
        }  
        return index + 1;  
    }

}
