package Program14;

import java.util.Date;

public abstract class GeometricObject {
	private String colorString = "White";
	private boolean filled;
	private Date createDate;
	
	protected GeometricObject(){
		createDate = new Date();
	}
	
	protected GeometricObject(String color, boolean filled){
		createDate = new Date();
		this.colorString = color;
		this.filled = filled;
	}
	
	public String getColor(){
		return colorString;
	}
	
	public void setColor(String color) {
		this.colorString = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public String toString() {
		return "Created on " + createDate + "\ncolor: " + colorString +
				" and filled: " + filled;
	}
	
	public abstract double getArea();
	
	public abstract double getPerimeter();
}
