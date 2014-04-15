package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String[]> res = new ArrayList<String[]>();
		res = solveNQueens(4);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).length; j++)
				System.out.println(res.get(i)[j]);
			System.out.println("-----" + i + "-----");
		}
	}

	public static ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		helper(n, 0, new int[n], res);
		return res;
	}

	private static void helper(int n, int row, int[] columForRow,
			ArrayList<String[]> res) {
		if (row == n) {
			String[] item = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuffer strRow = new StringBuffer();
				for (int j = 0; j < n; j++) {
					if (columForRow[i] == j)
						strRow.append('Q');
					else
						strRow.append('.');
				}
				item[i] = strRow.toString();
			}
			res.add(item);
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
