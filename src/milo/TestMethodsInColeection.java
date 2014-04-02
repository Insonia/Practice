package milo;

import java.util.HashSet;
import java.util.Set;

public class TestMethodsInColeection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<String>();
		
		set1.add("Milo");
		set1.add("is");
		set1.add("a");
		set1.add("big");
		set1.add("SB");
		
		System.out.println("Set1 ia " + set1);
		System.out.println(set1.size() + " elements in set1");
		
		set1.remove("is");
		System.out.println("\nSet1 ia " + set1);
		System.out.println(set1.size() + " elements in set1");
		
		Set<String> set2 = new HashSet<String>();
		
		set2.add("Milo");
		set2.add("is");
		set2.add("a");
		System.out.println("\nSet2 ia " + set2);
		System.out.println(set2.size() + " elements in set2");
		
		System.out.println("\nIs Tai in set set2? " + set2.contains("Tai"));
		
		set1.addAll(set2);
		System.out.println("\nAfetr adding set2 to set1, set1 is " + set1);
		
		set1.removeAll(set2);
		System.out.println("\nAfetr removing set2 from set1, set1 is " + set1);
		
		set1.retainAll(set2);
		System.out.println("\nAfetr removeing common elements in set2 from set1, set1 is " + set1);
	}

}
