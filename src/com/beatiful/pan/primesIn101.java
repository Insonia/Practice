package com.beatiful.pan;

import javax.security.auth.kerberos.KerberosKey;

public class primesIn101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[101];
		int[] b = new int[101];
		int i, j, k;
		for(i = 1; i< 101; i++){
			a[i] = 1;
			b[i] = 1;
		}
		//删除法
		for(i = 2; i < 101; i++){
			if(a[i] != 0)
				for(j = i + i ; j < 101;){
					if(j%i == 0)
						a[j] = 0;
					j = j + i;
				}
		}
		
		//开根号法
		for(i = 1;i < 101; i++)
		{
			k = (int)Math.sqrt(i);
			for( j =2; j<= k; j++)
				if(i%j == 0){
					b[i] = 0;
					break;
				}
			if(j > k)
				b[i] = 1;
		}
		for(i = 2; i < 101; i++){
			if(a[i] != 0)
				System.out.print("a:" + i + " ");
			if(b[i] != 0)
				System.out.println("b:" + i);
		}
	}

}
