package com.leetcode.oj;

//先转置，再反转
public class Solution_103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for(int i = 0; i < 3; i++){
			for(int j = 0 ; j < 3; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void rotate(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++){
        	for(int j = i + 1; j < matrix[0].length; j++)
        		swap(matrix,i,j);
        	reverse(matrix, i);
        }
    }
	
	public static void swap(int[][] matrix, int i, int j){
		int temp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = temp;
	}
	
	public static void reverse(int[][] matrix, int i){
		for(int j = 0, k = matrix[0].length - 1; j < k; j++, k--)
			swap1(matrix, i, j, k);
	}
	
	public static void swap1(int[][] matrix,int i, int j, int k){
		int temp = matrix[i][j];
		matrix[i][j] = matrix[i][k];
		matrix[i][k] = temp;
	}

}
