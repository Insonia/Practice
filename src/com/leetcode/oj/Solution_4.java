package com.leetcode.oj;

public class Solution_4 {

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
		
		ListNode head = sortList(node1);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head,slow = head;
        //快慢指针找到中间点
        while(fast.next != null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;
        fast = sortList(head);
        slow = sortList(slow);
        return merge(fast, slow);
    }
	
	public static ListNode merge(ListNode head1, ListNode head2){
		if(head1 == null) return head2;
		if(head2 == null) return head1;
		
		ListNode result,temp;
		if(head1.val < head2.val){
			result = head1;
			head1 = head1.next;
		}else {
			result = head2;
			head2 = head2.next;
		}
		
		temp = result;
		while(head1 != null && head2 != null){
			if(head1.val < head2.val){
				temp.next = head1;
				head1 = head1.next;
			}
			else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		if(head1 != null)temp.next = head1;
		else temp.next = head2;
		return result;
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
