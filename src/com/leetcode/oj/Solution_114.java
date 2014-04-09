package com.leetcode.oj;

//������n=1ʱ����ַ���1��n=2ʱ�����ϴ��ַ����е���ֵ��������Ϊ�ϴ��ַ�����1��1���������11��n=3ʱ��
//�����ϴ��ַ���11����2��1���������21��n=4ʱ�������ϴ��ַ�����21����1��2��1��1���������1211��

public class Solution_114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(6));
	}
	
	public static String countAndSay(int n) {
		if(n == 1){  
            return "1";  
        }  
          
        String s = "1";  
        StringBuffer ret = new StringBuffer();  
        int cnt = 0;  
        int round = 0;          // round�ǵ������ٴ�  
        int i;  
        while(++round < n){  
            cnt = 1;  
            ret.setLength(0);  
            for(i=1; i<s.length(); i++){  
                if(s.charAt(i) == s.charAt(i-1)){       // �ظ���ֵ����������  
                    cnt++;  
                }else{          // ���µ�ֵ���֣���¼��ret  
                    ret.append(cnt).append(s.charAt(i-1));  
                    cnt = 1;        // ����cnt  
                }  
            }  
            ret.append(cnt).append(s.charAt(i-1));  
            s = ret.toString(); // ����s  
        }  
        return ret.toString();  
    }

}
