package com.leetcode.oj;

public class Solution_107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,2,1,0,4};
		System.out.println(canJump(A));
	}
	
	public static boolean canJump(int[] A) {
        if(A.length <= 1) return true;
//        return helper(A, 0); 能通过测试，哈哈，不过递归复杂了
        
        //参考了别人的代码后写的，贪心算法
        int jump = 0;
        for(int i =0; i < A.length - 1; i++, jump--){
        	jump = jump > A[i] ? jump : A[i];
        	if(jump <= 0) return false;
        }
        return true;
    }
	
//	public static boolean helper(int[] A, int index){
//		if(A[index] >= A.length - index - 1) return true;
//		if(A[index] == 0) return false;
//		for(int i = index; i < A.length - 1; i++){
//			if(A[i] == 0) return false;
//			if(helper(A, A[i] + i)){
//				return true;
//			}
//		}
//		return true;
//	}

}
