package milo;

import java.util.Set;
import java.util.TreeSet;

import Program14.Circle;
import Program14.GeometricObject;
import Program14.Rectangle;

public class TestTreeSetWithComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<GeometricObject> set = new TreeSet<GeometricObject>(new GeometricObjectComparator());
		set.add(new Rectangle(4,5));
		set.add(new Circle(40));
		set.add(new Circle(40));
		set.add(new Rectangle(4,1));
		
		System.out.println("A sorted set of geometric objects");
		for(GeometricObject element : set)
			System.out.println("area = " + element.getArea());
	}

}
