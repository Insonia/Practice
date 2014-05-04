package com.leetcode.oj;

public class Solution_79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("asd", "ad"));
	}
	
	//DP
	public static int minDistance(String word1, String word2) {
        int row = word1.length() + 1;
        int col = word2.length() + 1;
        
        int[][] res = new int[row][col];
        for(int i = 0; i < row; i++)
        	res[i][0] = i;
        for(int i = 0; i < col; i++)
        	res[0][i] = i;
        for(int i = 1; i < row; i++)
        	for(int j = 1; j < col; j++){
        		if(word1.charAt(i - 1) == word2.charAt(j - 1))
        			res[i][j] = res[i - 1][j - 1];
        		else
        			res[i][j] = res[i - 1][j - 1] + 1;
        		res[i][j] = Math.min(res[i][j], Math.min(res[i - 1][j] + 1, res[i][j - 1] + 1));
         	}
        
        return res[row - 1][col - 1];
    }

}
