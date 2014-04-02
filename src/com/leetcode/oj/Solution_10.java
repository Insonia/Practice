package com.leetcode.oj;

import com.leetcode.oj.Solution_9.ListNode;

public class Solution_10 {
	
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		do {
			if(fast != null)
				fast = fast.next;
			if(fast != null)
				fast = fast.next;
			if(fast == null)
				return false;
			slow = slow.next;
		} while (fast != slow);
		return true;
    }
	
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int v) {
			val = v;
			next = null;
		}
	}
}
