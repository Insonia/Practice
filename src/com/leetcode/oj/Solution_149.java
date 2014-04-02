package com.leetcode.oj;

//There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
//The overall run time complexity should be O(log (m+n)).


//˼·��
//
//�����ǽ�ԭ����ת���һ��Ѱ�ҵ�kС�������⣨��������ԭ�����������У���������λ��ʵ�����ǵ�(m+n)/2С������
//����ֻҪ����˵�kС�������⣬ԭ����Ҳ���Խ����
//
//���ȼ�������A��B��Ԫ�ظ���������k/2�����ǱȽ�A[k/2-1]��B[k/2-1]����Ԫ�أ�������Ԫ�طֱ��ʾA�ĵ�k/2С��Ԫ�غ�B�ĵ�k/2С��Ԫ�ء�
//������Ԫ�رȽϹ������������>��<��=�����A[k/2-1]<B[k/2-1]�����ʾA[0]��A[k/2-1]��Ԫ�ض���A��B�ϲ�֮���ǰkС��Ԫ���С�
//���仰˵��A[k/2-1]�����ܴ���������ϲ�֮��ĵ�kСֵ���������ǿ��Խ���������
//
//֤��Ҳ�ܼ򵥣����Բ��÷�֤��������A[k/2-1]���ںϲ�֮��ĵ�kСֵ�����ǲ����ٶ���Ϊ�ڣ�k+1��Сֵ������A[k/2-1]С��B[k/2-1]��
//����B[k/2-1]�����ǵڣ�k+2��Сֵ����ʵ���ϣ���A���������k/2-1��Ԫ��С��A[k/2-1]��B��Ҳ�������k/2-1��Ԫ��С��A[k/2-1]��
//����С��A[k/2-1]��Ԫ�ظ���������k/2+ k/2-2��С��k������A[k/2-1]�ǵڣ�k+1������ì�ܡ�
//
//��A[k/2-1]>B[k/2-1]ʱ�������ƵĽ��ۡ�
//
//��A[k/2-1]=B[k/2-1]ʱ�������Ѿ��ҵ��˵�kС������Ҳ�������ȵ�Ԫ�أ����ǽ����Ϊm��������A��B�зֱ���k/2-1��Ԫ��С��m��
//����m���ǵ�kС������
//
//ͨ������ķ��������Ǽ����Բ��õݹ�ķ�ʽʵ��Ѱ�ҵ�kС�������������ǻ���Ҫ���Ǽ����߽�������
//
//���A����BΪ�գ���ֱ�ӷ���B[k-1]����A[k-1]��
//���kΪ1������ֻ��Ҫ����A[0]��B[0]�еĽ�Сֵ��
//���A[k/2-1]=B[k/2-1]����������һ����

public class Solution_149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2};
		int[] B = {2,3,4};
		System.out.println(findMedianSortedArrays(A, B));
	}
	
	public static double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        if(total % 2 != 0)
        	return findKth(A, B, total / 2 + 1);
        else
        	return (findKth(A, B, total / 2) + findKth(A, B, total / 2 + 1)) / 2;
    }
	
	public static double findKth(int A[], int B[], int k){
		if(B.length < A.length) return findKth(B, A, k);
		if(A.length == 0) return B[k - 1];
		if( k == 1) return A[0] < B[0] ? A[0] : B[0];
		int pa = A.length < k/2 ? A.length : k/2;
		int pb = k - pa;
		if(A[pa - 1] < B[pb - 1]){
			int[] T = new int[A.length - pa];
			System.arraycopy(A, pa, T, 0, A.length - pa);
			return findKth(T, B, k - pa);
		}else if (A[pa - 1] > B[pb - 1]) {
			int[] T = new int[B.length - pb];
			System.arraycopy(B, pb, T, 0, B.length - pb);
			return findKth(	A, T, k - pb);
		}else {
			return A[pa - 1];
		}
	}

}
