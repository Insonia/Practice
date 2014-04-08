package com.leetcode.oj;

//�ڵ�ǰ�����У���β����ǰѰ����������Ԫ�أ�ǰһ����Ϊ*i����һ����Ϊ*ii����������*i < *ii��Ȼ���ٴ�β��Ѱ����һ��Ԫ��*j��
//�������*i < *j��������i��Ԫ�����j��Ԫ�ضԵ���������ii��Ԫ��֮�󣨰���ii��������Ԫ�صߵ����򣬼������һ�������ˡ�

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
