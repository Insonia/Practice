package com.handsome.yin;

import java.util.ArrayList;

public class TestBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree<String> tree = new BinaryTree<String>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter");
		tree.insert("Daniel");
		
		System.out.print("Inorder (sorted): ");
		tree.inorder();
		System.out.print("\nPostOrder: ");
		tree.postorder();
		System.out.print("\nPreorder: ");
		tree.preorder();		
		System.out.println("\nThe number of nodes is " + tree.getSize());
		
		System.out.println("Is peter in the tree?" + tree.search("Peter"));
		
		System.out.println("A path from the root to Peter is: ");
		ArrayList<TreeNode<String>> path = tree.path("Peter");
		for(int i=0;path != null && i<path.size();i++)
			System.out.println(path.get(i).element + "");
		
		Integer[] numbersIntegers = {2,4,3,1,8,5,6,7};
		BinaryTree<Integer> intTree = new BinaryTree<Integer>(numbersIntegers);
		System.out.println("Inorder (sorted):");
		intTree.inorder();
	}

}
