package com.leetcode.oj;

import com.leetcode.oj.Solution_10.ListNode;

public class Solution_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		node2.next = node1;
		ListNode head = detectCycle(node2);
		System.err.println(head.val);
		System.out.println("123");
	}
	
	public static ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		do {
			if(fast != null)
				fast = fast.next;
			if(fast != null)
				fast = fast.next;
			if(fast == null)
				return fast;
			slow = slow.next;
		} while (fast != slow);
		
		fast = head;
		while(fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
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
