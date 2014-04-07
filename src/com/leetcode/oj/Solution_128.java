package com.leetcode.oj;

public class Solution_128 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head = swapPairs(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode temp = head;
		ListNode cur = head;
		ListNode end = cur.next;
		head = head.next;
		
		cur.next = end.next;
		end.next = cur;
		cur = cur.next;
		
		while(cur != null && cur.next != null){
			end = cur.next;
			cur.next = end.next;
			end.next = cur;
			temp.next = end;
			temp = cur;
			cur = cur.next;
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
