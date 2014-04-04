package com.leetcode.oj;

import java.util.ArrayList;

public class Solution_129 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        return helper(lists, 0, lists.size() - 1);
    }
	
	public static ListNode helper(ArrayList<ListNode> lists, int l ,int r){
		if(l < r){
			int m = (l + r)/2;
			return merge(helper(lists, l, m), helper(lists, m + 1, r));
		}
		return lists.get(l);
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

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
