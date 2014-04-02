package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Stack;

public class Solution_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root  = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		root.right = node1;
		node1.left = node2;
		root.left = node3;
		node3.left = node4;
		node1.right = node5;
		ArrayList<Integer> path = postorderTraversal(root);
		System.out.println(path);
	}
	
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        if(root == null)return path;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode current = null;
        while(!stack.isEmpty()){
        	current = stack.peek();
        	if(current.left == null && current.right == null){
        		path.add(current.val);
        		stack.pop();
        	}
        	else {
				if(current.right != null){
					stack.push(current.right);
					current.right = null;
				}
				if(current.left != null){
					stack.push(current.left);
					current.left = null;
				}
			}
        }
        return path;
    }
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v) {
			val = v;
			// TODO Auto-generated constructor stub
		}
	}

}
