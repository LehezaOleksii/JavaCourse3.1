package oleksii.leheza.java.lab3.entities;

public abstract class Shape implements Drawable {

	private String ShapeColor;

	Shape() {
		ShapeColor = "Black";
	}

	Shape(String ShapeColor) {
		this.ShapeColor = ShapeColor;
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
