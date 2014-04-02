package com.handsome.yin;

public class HuffmanCode {
	
	public static class Tree implements Comparable<Tree>{
		Node root;
		
		public Tree(Tree t1, Tree t2) {
			root = new Node();
			root.left = t1.root;
			root.right = t2.root;
			root.weight = t1.root.weight + t2.root.weight;
			// TODO Auto-generated constructor stub
		}
		
		public Tree(int weight, char element){
			root = new Node(weight,element);
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			if(root.weight < o.root.weight)
				return 1;
			else if(root.weight == o.root.weight)
				return 0;
			else
				return -1;
		}
		
	}
	
	public static class Node{
		char element;
		int weight;
		Node left;
		Node right;
		String code = "";
		
		public Node(){
			
		}
		
		public Node(int weight, char element){
			this.weight = weight;
			this.element = element;
		}
	}
}
