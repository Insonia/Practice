package com.leetcode.oj;

public class Solution_147 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		//l1.next = new ListNode(9);
		ListNode l2 = new ListNode(9);
//		l2.next = new ListNode(1);
//		l2.next.next = new ListNode(1);
		ListNode l = addTwoNumbers(l1, l2);
		while(l != null){
			System.out.print(l.val + " ");
			l = l.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode temp1 = l1;
	    ListNode temp2 = l2;
	    boolean delt = false;
		while( l1 != null && l2 != null){
	    	int v = l1.val + l2.val;
	    	if(delt){v++; delt = false;};
	    	if(v > 9){
	    		v -= 10;
	    		delt = true;
	    		if(l1.next == null){
	    			l1.next = new ListNode(0);
	    		}
	    	}
			l1.val = v;
	    	l2.val = v;
	    	l1 = l1.next;
	    	l2 = l2.next;
	    }
		if(delt){
			if(l1 != null){
				if(l1.val != 9){
					l1.val++;
				}else {		
					while(l1.val == 9){
						l1.val = 0;
						if(l1.next == null) { l1.next = new ListNode(0);l1 = l1.next; break;};
						l1 = l1.next;
					}
					l1.val ++;
				}
				return temp1;
			}else{
				return temp2;
			}
		}
	    if(l1 != null) return temp1;
	    else return temp2;
	}
	
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
