package com.leetcode.oj;

public class Solution_106 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,4};
		System.out.println(jump(A));
	}
	
	//http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html Å£±Æ
	public static int jump(int[] A) {
		int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = curr > i + A[i] ? curr : i + A[i];
        }

        return ret;
    }
	
//	public static boolean canJump(int[] A) {
//        if(A.length <= 1) return true;
//        return helper(A, 0);
//    }
//	
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
