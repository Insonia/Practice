package Program13;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		
		set.add("Milo");
		set.add("is");
		set.add("a");
		set.add("SB");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next().toUpperCase() + " ");
	}

}
