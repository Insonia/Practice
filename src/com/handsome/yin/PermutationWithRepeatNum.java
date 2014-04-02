package com.handsome.yin;

import java.util.Scanner;

//若要改为含重复元素的全排列，需要加减枝的条件:
//
//1.若 t 指向的元素与 j 指向的元素相同且i，j的值不同，则不继续深入搜索，
//如   a  m  a   c   d   e（当 t 指向第一个a，j 指向第2个a时，程序跳入下一个循环）
//
//2.若t，j指向的元素值不同，但 j 指向的元素与  j之前，t 之后的某一元素相同，则则不继续深入搜索，
//如： m a b c d m f m  e g h（当 t 指向a，j 指向 t 之后的第二个m时，程序跳入下一个循环）
public class PermutationWithRepeatNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter numbers:");
		String s = input.nextLine();
		char[] a = s.toCharArray();
		permutation(a, 0, a.length);
	}

	public static void permutation(char[] a, int t, int n) {
		if (t == n) {
			for (int i = 0; i < n; i++)
				System.out.print(a[i]);
			System.out.println();
			return;
		}

		for (int j = t; j < n; j++) {
			int flag = 1;
			for (int r = t; r < j; r++) {
				if (a[r] == a[j]) {
					flag = 0;
					break;
				}
			}
			if (flag == 0) {
				continue;
			}
			swap(a,j,t);
			permutation(a, t + 1, n);
			swap(a,j,t);
		}
	}
	
	private static void swap(char[] a,int i, int j){
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
