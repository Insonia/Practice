package milo;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new LinkedHashSet<String>();
		
		set.add("Milo");
		set.add("is");
		set.add("a");
		set.add("big");
		set.add("SB");
		
		System.out.print(set);
		
		for (String string : set) {
			System.out.print(string.toString().toUpperCase() + " ");
		}
	}

}
