package Program14;

public class Circle extends GeometricObject {
	private double radius;
	
	public Circle(){
		
	}
	
	public Circle(double radius){
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled){
		super(color,filled);
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public double getDiameter() {
		return 2* radius;
	}
	
	public void printCicrcle() {
		System.out.println("The Circle is created " + getCreateDate() + " and the radius is " + radius);
	}
}
