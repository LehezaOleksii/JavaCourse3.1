package oleksii.leheza.java.lab.lab_10_.entities;

import oleksii.leheza.java.lab.lab_10_.main.MyLogger;

public abstract class Shape implements Drawable {

	private String ShapeColor;

	Shape() {
		ShapeColor = "Black";
		MyLogger.logDebug("Shape " + this.getClass().getSimpleName() + " was Created");
	}

	Shape(String ShapeColor) {
		this.ShapeColor = ShapeColor;
		MyLogger.logDebug(
				"Shape " + this.getClass().getSimpleName() + " with color " + this.getShapeColor() + " was Created");

	}

	public abstract double calcArea();

	public String getShapeColor() {
		return ShapeColor;
	}

	public void setShapeColor(String shapeColor) {
		ShapeColor = shapeColor;
	}

	@Override
	public String toString() {
		return "Shape [ShapeColor=" + ShapeColor + "]";
	}
}
