package com.leetcode.oj;

import com.leetcode.oj.Solution_4.ListNode;

public class Solution_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode head = insertionSortList(node1);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
        if(head == null ) return head;
        ListNode current = head.next;
        ListNode temp = null;
        
        while(current != null){
        	temp = head;
        	while(temp.val < current.val && temp != current)
        		temp = temp.next;
        	if(temp != current){
        		int first = current.val;
        		int second;
        		while(temp != current){
        			second = temp.val;
        			temp.val = first;
        			first = second;
        			temp = temp.next;
        		}
        		temp.val = first;
        	}
        	current = current.next;
        }
        
        return head;
    }
	
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			// TODO Auto-generated constructor stub
			val = x;
			next = null;
		}
	}

}
