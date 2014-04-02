package HelloWorld;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object circle1 = new Circle();
		Object circle2 = new Circle();
		
		System.out.println(circle1.equals(circle2));
	}

}

class Circle{
	double radius;
	
	public boolean equals(Circle circle)
	{
		return this.radius == circle.radius; 
	}
	
//	public boolean equals(Object o) {
//		return this.radius == ((Circle)o).radius;
//	}
}
