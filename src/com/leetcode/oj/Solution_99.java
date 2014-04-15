package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(totalNQueens(8));
	}
	
	public static int totalNQueens(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        helper(n, 0, new int[n], res);
        return res.get(0);
    }
	
	private static void helper(int n, int row, int[] columForRow,
			ArrayList<Integer> res) {
		if (row == n) {
			res.set(0, res.get(0) + 1);
			return;
		}
		for (int i = 0; i < n; i++) {
			columForRow[row] = i;
			if (isValid(row, columForRow)) {
				helper(n, row + 1, columForRow, res);
			}

		}
	}

	private static boolean isValid(int row, int[] columnForRow) {
		for (int i = 0; i < row; i++) {
			if (columnForRow[row] == columnForRow[i]
					|| Math.abs(columnForRow[row] - columnForRow[i]) == row - i)
				return false;
		}
		return true;
	}

}
