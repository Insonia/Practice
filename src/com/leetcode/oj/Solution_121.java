package com.leetcode.oj;

//在当前序列中，从尾端往前寻找两个相邻元素，前一个记为*i，后一个记为*ii，并且满足*i < *ii。然后再从尾端寻找另一个元素*j，
//如果满足*i < *j，即将第i个元素与第j个元素对调，并将第ii个元素之后（包括ii）的所有元素颠倒排序，即求出下一个序列了。

public class Solution_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,5};
		nextPermutation(num);
		for(int n : num)
			System.out.print(n + " ");
	}
	
	public static void nextPermutation(int[] num) {
       if(num.length < 2) return;
       int last = num.length - 1;
       int i = last;
       while(true){
    	   int ii = i;
    	   i--;
    	   if(num[i] < num[ii]){
    		   int j = last + 1;
    		   while(j >= 0 && (!(num[i] < num[--j])));
    		   
    		   swap(num, i, j);
    		   reverse(num, ii, last);
    		   return;
    	   }
    	   
    	   if(i == 0){
    		   reverse(num, 0, last);
    		   return;
    	   }
       }
    }
	
	private static void swap(int[] a,int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void reverse(int[] a ,int i, int j){
		while(i < j){
			swap(a, i, j);
			i++;
			j--;
		}
	}

}
