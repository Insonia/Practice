package com.leetcode.oj;

import java.util.HashMap;

//ʹ��map+˫���������Ӷ���O(logN)
//
//����ͷ���ı�ʾ�ոշ��ʹ��ģ�����β���ı�ʾ�ܾ�֮ǰ���ʵ�
//
//ÿ��get(key)������map���ҵ�����ڵ㣬Ȼ�������ڵ�ŵ�����ͷ����
//
//ÿ��set(key, value)������map��������ڵ㣬����еĻ��Ͱ�����ڵ�ŵ�����ͷ�������û�оͿ���cache�ռ��Ƿ��Ѿ����ˣ�size>=capacity��
//
//���δ����������һ���µĽڵ�ŵ�����ͷ����������ˣ�������һ���µĽڵ�ŵ�����ͷ������ɾ������β����һ���ڵ㡣

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
