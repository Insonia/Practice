package milo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestArrayAndLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(1);
		arrayList.add(0,40);
		arrayList.add(3,30);
		
		System.out.println("A list of integer in the array list:");
		System.out.println(arrayList);
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>(arrayList);
		ListIterator<Integer> listIterator = linkedList.listIterator();
		while(listIterator.hasNext()){
			System.out.print(listIterator.next() + " ");
		}
		
		System.out.println("\nDispaly the linked list backward:");
		listIterator = linkedList.listIterator(linkedList.size());
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}
	}

}
