package com.leetcode.oj;

public class Solution_108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isMatch("abbcddd**fdgsfgsdfhdsfhdsfh", "?*c"));
	}

	public static boolean isMatch(String s, String p) {
		int sIndex = 0;
		int pIndex = 0;
		int star = -1;
		int sp = 0;
		while (sIndex < s.length()) {
			if (pIndex < p.length()) {
				if (p.charAt(pIndex) == '?'
						|| s.charAt(sIndex) == p.charAt(pIndex)) {
					sIndex++;
					pIndex++;
					continue;
				}
				if (p.charAt(pIndex) == '*') {
					star = pIndex++;
					sp = sIndex;
					continue;
				}
			}
			if (star != -1) {
				pIndex = star + 1;
				sIndex = ++sp;
				continue;
			}
			return false;
		}
		while (pIndex < p.length()) {
			if (p.charAt(pIndex) != '*')
				break;
			pIndex++;
		}
		if (pIndex == p.length())
			return true;
		return false;

	}

}
