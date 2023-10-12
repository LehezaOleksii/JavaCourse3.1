package oleksii.leheza.java.lab.lab_10_.entities;

import java.io.Serializable;

public class Circle extends Shape implements Serializable {

	private double radius;

	public Circle(double radius, String ShapeColor) {
		super(ShapeColor);
		this.radius = radius;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println(this.toString() + " was drawn");
	}

	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

}
