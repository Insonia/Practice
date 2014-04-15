package com.leetcode.oj;

public class Solution_101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3.89707 * 3.89707);
		System.out.println(pow(3.89707, 2));
	}
	
	public static double pow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        double temp = pow(x, Math.abs(n/2));
//        if(n % 2 == 0){
//        	if(n > 0)
//        		return temp * temp;
//        	else
//        		return 1.0/(temp * temp);
//        }else {
//			if(n > 0)
//				return temp*temp*x;
//			else
//				return 1.0/(temp*temp*x);
//		}
        
        if(n > 0){
        	if( n % 2 == 0)
        		return temp * temp;
        	else
        		return temp * temp * x;
        }else {
			if(n % 2 == 0)
				return 1.0 / ( temp * temp);
			else
				return 1.0 / ( temp * temp * x);
		}
    }

}
