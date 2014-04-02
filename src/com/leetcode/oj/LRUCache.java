package com.leetcode.oj;

import java.util.HashMap;

//使用map+双向链表，复杂度是O(logN)
//
//链表头部的表示刚刚访问过的，链表尾部的表示很久之前访问的
//
//每次get(key)，先在map中找到这个节点，然后把这个节点放到链表头部。
//
//每次set(key, value)，现在map中找这个节点，如果有的话就把这个节点放到链表头部，如果没有就看看cache空间是否已经满了，size>=capacity，
//
//如果未满，就生成一个新的节点放到链表头部，如果满了，就生成一个新的节点放到链表头部并且删除链表尾部的一个节点。

public class LRUCache {
	HashMap<Integer, Node> map = new HashMap<Integer, LRUCache.Node>();
	Node head;
	Node tail;
	int size;
	int capacity;
	
	public LRUCache(int capacity) {
		if(capacity<1) return;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		map.clear();
		size = 0;
		this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
        	return -1;
        }else {
			Node current = map.get(key);
			current.pre.next = current.next;
			current.next.pre = current.pre;
			putToHead(current);
			return current.value;
		}
    }
    
    public void set(int key, int value) {
        if(capacity < 1) return;
        if(map.containsKey(key)){
        	Node current = map.get(key);
        	current.pre.next = current.next;
			current.next.pre = current.pre;
			current.value = value;
			putToHead(current);
        }else {
			Node temp = new Node(key, value);
			putToHead(temp);
			map.put(key, temp);
			if(size < capacity){
				size++;
			}else {
				Node delete = tail.pre;
				tail.pre = delete.pre;
				delete.pre.next = tail;
				map.remove(delete.key);
				delete = null;
			}
		}
    }
    
    public void putToHead(Node current){
    	current.next = head.next;
    	current.pre = head;
    	current.next.pre = current;
    	head.next = current;
    }
	
	static class Node{
		Node pre;
		Node next;
		int key;
		int value;
		public Node(int k, int v) {
			key = k;
			value = v;
		}
	}
}
