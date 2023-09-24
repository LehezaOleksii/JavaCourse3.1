package oleksii.leheza.java.lab5.entities;

import java.io.Serializable;

public class Rectangle extends Shape implements Serializable {

	private double height;
	private double width;

	public Rectangle(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}

	public Rectangle(double height, double width, String shapeColor) {
		super(shapeColor);
		this.height = height;
		this.width = width;
	}

	@Override
	public void draw() {
		System.out.println(this.toString() + " was drawn");
	}

	@Override
	public double calcArea() {
		return height * width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}

}
