package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Stack;

import com.leetcode.oj.Solution_7.TreeNode;
	
public class Solution_8 {
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
		ArrayList<Integer> path = preorderTraversal(root);
		System.out.println(path);
	}
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> path = new ArrayList<Integer>();      
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
        	if(root != null){
        		while(root != null){
        			path.add(root.val);
        			stack.push(root);
        			root = root.left;
        		}
        	}
        	else {
				root = stack.peek().right;
				stack.pop();
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
