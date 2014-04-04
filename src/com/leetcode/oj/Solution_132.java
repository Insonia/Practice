package com.leetcode.oj;

public class Solution_132 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n < 1) return head;
		ListNode p1 = head;
		ListNode p2 = head;
		while(n > 0 && p1 != null){p1 = p1.next; n--;}
		if(p1 == null){
			if(n == 0){
				head = p2.next;
				return head;
			}
			return head;
		}
		while(p1.next != null){p1 = p1.next; p2 = p2.next;}
		p1 = p2.next;
		p2.next = p1.next;
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
