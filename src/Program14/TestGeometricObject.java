package Program14;

public class TestGeometricObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeometricObject geoObject1 = new Circle(5);
		GeometricObject geoObject2 = new Rectangle(5,3);
		
		System.out.println("The two objects have the same area? " +
		 equalArea(geoObject1, geoObject2));
		
		displayGeometricObject(geoObject1);
		
		displayGeometricObject(geoObject2);
	}
	
	public static boolean equalArea(GeometricObject obj1, GeometricObject obj2) {
		return obj1.getArea() == obj2.getArea() ? true :false;
	}
	
	public static void displayGeometricObject(GeometricObject obj){
		System.out.println("\nThe area is " + obj.getArea() + 
				"\nThe preimeter is " + obj.getPerimeter());
	}

}
