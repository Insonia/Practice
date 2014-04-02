package com.leetcode.oj;

import com.leetcode.oj.Solution_4.ListNode;

public class Solution_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		
		reorderList(head);
		System.out.println(head.val);
		System.out.println(head.next.val);
		System.out.println(head.next.next.val);
		System.out.println(head.next.next.next.val);
	}
	
	public static void reorderList(ListNode head) {
//		ListNode temp = head;
//		ListNode last = head;
//		ListNode last_1 = null;//Last前面一個
//		while(head != null && head.next != null){
//			while(last.next != null){
//				last_1 = last;
//				last = last.next;
//			}
//			last_1.next = null;
//			last.next = head.next;
//			head.next = last;
//			head = last.next;
//			last = head;
//		}
//		head = temp;	此方法复杂度太大
		
		if(head == null || head.next == null) return;
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;
		head2 = reverseList(head2);
		ListNode p1 = head;
		ListNode p2 = head2;
		ListNode temp = null;
		while(p1 != null && p2 != null){
			temp = p1.next;
			p1.next = p2;
			p1 = temp;
			temp = p2.next;
			p2.next = p1;
			p2 = temp;
		}
    }
	
	public static ListNode reverseList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode temp = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return temp;
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
