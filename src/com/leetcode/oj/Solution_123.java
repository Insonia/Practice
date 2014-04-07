package com.leetcode.oj;

public class Solution_123 {

	public static void main(String[] args) {
		//// TODO Auto-generated method stub
		System.out.println(divide(4, 2));
	}
	
	//乘法就是加法，除法就是减法
	public static int divide(int dividend, int divisor) {
        long a = Math.abs((long)(dividend));
        long b = Math.abs((long)divisor);
        long res = 0;
        while( a >= b){
        	long c = b;
        	for( int i = 0; a >= c; i++, c <<= 1){
        		a -= c;
        		res += 1<<i;
        	}
        }
        return (int) (((dividend ^ divisor) >> 31 == 0 )? res : -res);
    }

}
