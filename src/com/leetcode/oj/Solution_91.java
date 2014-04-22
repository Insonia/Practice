package com.leetcode.oj;

public class Solution_91 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		
		head = rotateRight(head, 2);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode rotateRight(ListNode head, int n) {
//		if(head == null || head.next == null) return head;
//		
//		ListNode pre = head;
//		ListNode index = head;
//		head = head.next;
//		n--;
//		
//		while(head.next != null){
//			if(n >= 0){
//				n--;
//				pre = pre.next;
//			}
//			head = head.next;
//		}
//
//		head.next = index;
//		head = pre.next;
//		pre.next = null;
//		
//		return head;
		
		if(head != null){
			int len = 1;
			ListNode p = head;
			while(p.next != null){
				p = p.next;
				len++;
			}
			p.next = head;
			n %= len;
			int s = len - n;
			while(s > 0){
				p = p.next;
				s--;
			}
			head = p.next;
			p.next = null;
		}
		
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
