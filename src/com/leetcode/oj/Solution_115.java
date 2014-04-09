package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_115 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}};
		solveSudoku(board);
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
	}
	
	public static  void solveSudoku(char[][] board) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++)
        	for(int j = 0; j < 9; j++)
        		if(board[i][j] == '.')
        			array.add(i * 9 + j);
        DFS(board, array, 0);
	}
	
	public static boolean DFS(char[][] board, ArrayList<Integer> array, int index){
		if(index == array.size())
			return true;
		int data = array.get(index);
		int row = data / 9;
		int colum = data % 9;
		for(int i = 1; i<= 9; i++){
			if(isValid(board, row, colum, i))
				board[row][colum] = (char)(i + '0');
			if(DFS(board, array, index + 1))
				return true;
			board[row][colum] = '.';
		}
		return false;
	}
	
	public static boolean  isValid(char[][] board, int row, int colum, int data) {
		for(int i = 0; i < 9; i++){
			if(board[row][i] - '0' == data)
				return false;
			if(board[i][colum] - '0' == data)
				return false;
			int row_b = 3 * (row / 3) + i /3;
			int col_b = 3 * (colum / 3) + i %3;
			if(board[row_b][col_b] - '0' == data)
				return false;						
		}
		return true;
	}

}
