package com.handsome.yin;

import java.util.Scanner;

//��Ҫ��Ϊ���ظ�Ԫ�ص�ȫ���У���Ҫ�Ӽ�֦������:
//
//1.�� t ָ���Ԫ���� j ָ���Ԫ����ͬ��i��j��ֵ��ͬ���򲻼�������������
//��   a  m  a   c   d   e���� t ָ���һ��a��j ָ���2��aʱ������������һ��ѭ����
//
//2.��t��jָ���Ԫ��ֵ��ͬ���� j ָ���Ԫ����  j֮ǰ��t ֮���ĳһԪ����ͬ�����򲻼�������������
//�磺 m a b c d m f m  e g h���� t ָ��a��j ָ�� t ֮��ĵڶ���mʱ������������һ��ѭ����
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
