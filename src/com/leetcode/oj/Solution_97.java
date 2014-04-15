package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_97 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{2,3}};
		System.out.println(spiralOrder(matrix));
	}

	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> order = new ArrayList<Integer>(); 
	    if (matrix.length == 0 || matrix[0].length == 0) return order;
	    
	    int xMin = 0;
	    int yMin = 0;
	    int xMax = matrix[0].length - 1;
	    int yMax = matrix.length - 1;

	    order.add(matrix[0][0]);
	    
	    int i = 0, j = 0;
	    while (true) {
	        while (i < xMax)    order.add(matrix[j][++i]);
	        if (++yMin > yMax)    break;
	        
	        while (j < yMax)    order.add(matrix[++j][i]);
	        if (xMin > --xMax)    break;
	        
	        while (i > xMin)    order.add(matrix[j][--i]);
	        if (yMin > --yMax)    break;
	        
	        while (j > yMin)    order.add(matrix[--j][i]);
	        if (++xMin > xMax)    break;
	    }
	    return order;
	}

}
