package milo;

import java.io.Serializable;
import java.util.Comparator;

import Program14.GeometricObject;

public class GeometricObjectComparator implements Comparator<GeometricObject>, Serializable {

	@Override
	public int compare(GeometricObject o1, GeometricObject o2) {
		// TODO Auto-generated method stub
		double area1 = o1.getArea();
		double area2 = o2.getArea();
		if(area1 < area2)
			return -1;
		else if(area1 == area2)
			return 0;
		else
			return 1;
	}

}
