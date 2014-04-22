package com.leetcode.oj;

public class Solution_93 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] res = generateMatrix(1);
		for(int i = 0; i < res.length; i++){
			for(int j = 0; j < res[0].length; j ++)
				System.out.print(res[i][j] + "  ");
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix(int n) {
        int i = 0;
        int j = n - 1;
        int num = 1;
        int[][] res = new int[n][n];
        
        for(; i < j; i++, j--){
        	for(int k = i; k <= j; k++){
        		res[i][k] = num++;
        	}
        	
        	for(int k = i + 1; k < j; k++)
        		res[k][j] = num++;
        	
        	for(int k = j; k >= i; k--)
        		res[j][k] = num++;
        	
        	for(int k = j - 1; k > i; k--)
        		res[k][i] = num++;
        }
        
        if(i == j) res[i][j] = num;
        
        return res;
    }
}
