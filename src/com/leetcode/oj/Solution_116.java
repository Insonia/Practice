package com.leetcode.oj;

public class Solution_116 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        for(int i = 0; i < 9; i++)
        	for(int j = 0; j < 9; j++){
        		row[i][j] = false;
        		col[i][j] = false;
        		block[i][j] = false;
         	}
        for(int i= 0; i < 9; i++)
        	for(int j = 0; j < 9; j++){
        		if(board[i][j] == '.') continue;
        		int c = board[i][j] - '1';
        		if(row[i][c] == true || col[j][c] == true || block[i - i % 3 + j / 3][c] == true) return false;
        		row[i][c] = true;
        		col[j][c] = true;
        		block[i - i % 3 + j / 3][c] = true;
        	}
        return true;
    }

}
