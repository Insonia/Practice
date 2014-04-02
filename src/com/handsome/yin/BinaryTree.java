package com.handsome.yin;

import java.util.ArrayList;
import java.util.Iterator;

import javax.lang.model.element.Element;


public class BinaryTree<E extends Comparable<E>> extends AbstractTree<E> {
	private TreeNode<E> root;
	protected int size = 0;
	
	public BinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryTree(E[] objects){
		for(int i = 0; i< objects.length; i++)
			insert(objects[i]);
	}
	
	@Override
	public boolean search(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> current = getRoot();
		
		while(current != null)
			if(e.compareTo(current.element) < 0)
				current = current.left;
			else if(e.compareTo(current.element) > 0)
				current = current.right;
			else
				return true;
		
		return false;
	}

	@Override
	public boolean insert(E e) {
		// TODO Auto-generated method stub
		if(getRoot() == null)
			setRoot(createNewNode(e));
		else {
			TreeNode<E> parent = null;
			TreeNode<E> current = getRoot();
			while(current != null)
				if(e.compareTo(current.element) < 0){
					parent = current;
					current = current.left;
				}
				else if (e.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				}
				else {
					return false;
				}
			
			if(e.compareTo(parent.element) < 0)
				parent.left = createNewNode(e);
			else {
				parent.right = createNewNode(e);
			}
		}
		
		size++;
		return false;
	}
	
	protected TreeNode<E> createNewNode(E e){
		return new TreeNode<E>(e);
	}
	
	public void inorder() {
		inorder(getRoot());
	}
	
	protected void inorder(TreeNode<E> root) {
		if(root == null)return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}
	
	public void postorder(){
		postorder(getRoot());
	}
	
	public void postorder(TreeNode<E> root){
		if(root == null)return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}
	
	public void preorder() {
		preorder(getRoot());
	}
	
	public void preorder(TreeNode<E> root){
		if(root == null)return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public ArrayList<TreeNode<E>> path(E e){
		ArrayList<TreeNode<E>> list = new ArrayList<TreeNode<E>>();
		TreeNode<E> current = getRoot();
		
		while(current != null){
			list.add(current);
			if(e.compareTo(current.element) < 0)
				current = current.left;
			else if(e.compareTo(current.element) > 0)
				current = current.right;
			else {
				break;
			}
		}
		
		return list;
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		TreeNode<E> parent = null;
		TreeNode<E> current = getRoot();
		while(current != null){
			if(e.compareTo(current.element) < 0){
				parent = current;
				current = current.left;
			}
			else if (e.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			}
			else
				break;
		}
		
		if(current == null)
			return false;
		
		if(current.left == null){
			if(parent == null)
				setRoot(current.right);
			else{
				if(e.compareTo(parent.element) < 0)
					parent.left = current.right;
				else 
					parent.right = current.right;
			}
		}
		else {
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;
			
			while(rightMost.right != null){
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			
			current.element = rightMost.element;
			
			if(parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				parentOfRightMost.left = rightMost.left;
		}
		
		size--;
		return true;
	}
	
	public Iterator iterator(){
		return inorderIterator();
	}
	
	public Iterator inorderIterator(){
		return new InorderIterator();
	}
	
	class InorderIterator implements Iterator{
		private ArrayList<E> list = new ArrayList<E>();
		private int current = 0;
		
		public InorderIterator() {
			inorder();
			// TODO Auto-generated constructor stub
		}
		
		private void inorder() {
			inorder(getRoot());
		}
		
		private void inorder(TreeNode<E> root) {
			if(root == null)return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(current < list.size())
				return true;
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return list.get(current++);
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			delete(list.get(current));
			list.clear();
			inorder();
		}
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void clear()
	{
		setRoot(null);
		size = 0;
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<E> root) {
		this.root = root;
	}
	
}
