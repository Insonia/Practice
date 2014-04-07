package com.leetcode.oj;

public class Solution_127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2 || head == null) return head;
        ListNode preHead = null;
        ListNode postTail = null;
        ListNode tail = head;
        int num = 1;
        while(num < k && tail.next != null){
        	num++;
        	tail = tail.next;
        }
        if(num < k)
        	return head;
        postTail = tail.next;
        tail.next = null;
        tail = head;
        head = reverseNode(head);
        tail.next = postTail;
        preHead = tail;
        tail = preHead.next;
        while(tail != null){
        	num = 1;
        	while(num < k && tail.next != null){
        		num++;
        		tail = tail.next;
        	}
        	if(num < k)
        		return head;
        	postTail = tail.next;
        	tail.next = null;
        	reverseNode(preHead.next);
        	preHead.next.next = postTail;
        	postTail = preHead.next;
        	preHead.next = tail;
        	preHead = postTail;
        	tail = preHead.next;
        }
        return head;
    }
	
	public static ListNode reverseNode(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode tempHead = reverseNode(head.next);
		head.next.next = head;
		head.next = null;
		return tempHead;
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
