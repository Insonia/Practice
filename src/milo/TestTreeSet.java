package milo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		set.add("Milo");
		set.add("is");
		set.add("a");
		set.add("big");
		set.add("SB");
		
		TreeSet<String> treeSet = new TreeSet<String>(set);
		//TreeSet<String> teStrings = new Tr
		System.out.println("The sorted set: " + treeSet);
		
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		System.out.println(treeSet.headSet("Milo"));
		System.out.println(treeSet.tailSet("Milo"));
		
		System.out.println(treeSet.lower("P"));
		System.out.println(treeSet.higher("P"));
		System.out.println(treeSet.floor("P"));
		System.out.println(treeSet.ceiling("P"));
		System.out.println(treeSet.pollFirst());
		System.out.println(treeSet.pollLast());
		System.out.println(treeSet);
		
		
	}

}
