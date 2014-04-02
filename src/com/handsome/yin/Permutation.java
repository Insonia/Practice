package com.handsome.yin;

import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[] a = {'1','2','3'};
//		permutation(a, 0, 3);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter numbers:");
		String s = input.nextLine();
		char[] a = s.toCharArray();
		permutation(a, 0, a.length);
	}
	
	public static void permutation(char[] a, int t, int n){
		if(t== n){
			for(int i = 0; i< n; i++)
				System.out.print(a[i]);
			System.out.println();
			return;
		}
		
		for(int j=t; j < n ;j++){
			swap(a, j, t);
			permutation(a, t+1, n);
			swap(a, j, t);
		}
	}
	
	private static void swap(char[] a,int i, int j){
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
