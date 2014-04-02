package milo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

public class SetListPerformanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<Integer> set1 = new HashSet<Integer>();
		System.out.println("Time hash ste: " + getTestTime(set1, 500000) + "ms");
		
		Collection<Integer> set2 = new LinkedHashSet<Integer>();
		System.out.println("Time hash ste: " + getTestTime(set2, 500000) + "ms");
		
		Collection<Integer> set3 = new TreeSet<Integer>();
		System.out.println("Time hash ste: " + getTestTime(set3, 500000) + "ms");
		
		Collection<Integer> list1 = new ArrayList<Integer>();
		System.out.println("Time hash ste: " + getTestTime(list1, 60000) + "ms");
		
		Collection<Integer> list2 = new LinkedList<Integer>();
		System.out.println("Time hash ste: " + getTestTime(list2, 500000) + "ms");
	}
	
	public static long getTestTime(Collection<Integer> c, int size){
		long startTime = System.currentTimeMillis();
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i =0; i<size;i++)
			list.add(i);
		
		Collections.shuffle(list);
		
		for(int element : list)
			c.add(element);
		
		for(int element : list)
			c.remove(element);
		
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

}
