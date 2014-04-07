package com.leetcode.oj;

public class Solution_125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2};
		System.out.println(removeElement(A, 2));
	}
	
	public static int removeElement(int[] A, int elem) {
        //if(A.length == 1 && A[0] == elem) return 0;
		int cur = A.length - 1;
        int last = A.length - 1;
        for(; cur >= 0; cur--){
        	if(A[cur] == elem){
        		if(cur == last){
        			last--;
        		}else {
					A[cur] = A[last];
					last--;
				}
        	}
        }
        return last+1;
    }

}
