package com.leetcode.oj;

public class Solution_145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 2));
	}
	
	public static String convert(String s, int nRows) {
//		if(s.length() < 1) return s;
//        int numOfrows = s.length()/(nRows + nRows / 2);
//        if(s.length() % (nRows+ nRows/2) != 0) numOfrows += 1;
//        //if(s.length() == nRows) numOfrows += 1;
//        char[][] chars = new char[numOfrows][nRows + nRows/2];
//        for(int i = 0; i < numOfrows; i++)
//        	for(int j = 0; j < (nRows + nRows/2); j++)
//        		chars[i][j] = '#';
//        StringBuffer result = new StringBuffer();
//        int r,c;
//        for(int i = 0; i < s.length(); i++){
//        	r = i / (nRows + nRows / 2);
//        	c = i % (nRows + nRows / 2);
//        	chars[r][c] = s.charAt(i);
//        }
//        for( int i = 0; i < nRows; i ++){
//        	if(i % 2 == 0){
//        		for(int j = 0; j < numOfrows; j++)
//        			if(chars[j][i] != '#')
//        			result.append(chars[j][i]);
//        	}else {
//				for(int j = 0; j < numOfrows; j++){
//					if(chars[j][i] != '#')
//					result.append(chars[j][i]);
//					if(chars[j][nRows + i / 2] != '#')
//					result.append(chars[j][nRows + i /2]);
//				}
//			}
//        }
//        return result.toString();
		
		if(nRows < 2) return s;
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < nRows; i++){
			for(int j = i; j < s.length(); j += 2 * (nRows - 1)){
				result.append(s.charAt(j));
				if( i > 0 && i < nRows - 1){
					if( j + 2 * (nRows - i - 1) < s.length()){
						result.append(s.charAt(j + 2 * (nRows - i - 1)));
					}
				}
			}
		}
		return result.toString();
    }
}
