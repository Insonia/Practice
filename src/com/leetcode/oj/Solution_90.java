package com.leetcode.oj;

public class Solution_90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3, 10));
	}
	
	public static int uniquePaths(int m, int n) {
//		if(m == 0 || n == 0)  
//            return 0;  
//        int[][] dp = new int[m][n];  
//        dp[0][0] = 1;  
//        for(int i = 1; i < m; i++)  
//            dp[i][0] = 1;  
//        for(int j = 1; j < n; j++)  
//            dp[0][j] = 1;  
//        for(int i = 1; i < m; i++)  
//        {  
//            for(int j = 1; j < n; j++)  
//            {  
//                dp[i][j] = dp[i][j-1] + dp[i-1][j];  
//            }  
//        }  
//        int res = dp[m-1][n-1];
//        return res;
		
		if (n == 1 || m == 1) return 1;  
		  
        int[] A = new int[n];  
        for (int i = 1; i <= n; i++)  
        {  
            A[i-1] = i;//i-1写出i会造成下标超范围  
        }  
  
        for (int i = 2; i < m; i++)  
        {  
            for (int j = 1; j < n; j++)  
            {  
                A[j] += A[j-1];  
            }  
        }  
        return A[n-1];
    }

}
