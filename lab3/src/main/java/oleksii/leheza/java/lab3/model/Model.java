package oleksii.leheza.java.lab3.model;

import java.util.ArrayList;
import java.util.List;

import oleksii.leheza.java.lab3.entities.Circle;
import oleksii.leheza.java.lab3.entities.Rectangle;
import oleksii.leheza.java.lab3.entities.Shape;
import oleksii.leheza.java.lab3.entities.Triangle;

public class Model {

	private List<Shape> shapes = new ArrayList<>();

	public Model() {
		shapes.add(new Rectangle(5, 10, "Blue"));
		shapes.add(new Rectangle(10, 2, "Red"));
		shapes.add(new Rectangle(4, 3, "White"));
		shapes.add(new Rectangle(7, 10, "Purple"));
		shapes.add(new Triangle(5, 10, 7, "Blue"));
		shapes.add(new Triangle(3, 2, 4, "Yellow"));
		shapes.add(new Triangle(10, 10, 10, "Orange"));
		shapes.add(new Circle(5, "Brown"));
		shapes.add(new Circle(10, "Grey"));
		shapes.add(new Circle(18, "Blue"));
	}

	public Shape getShape(int id) {
		return shapes.get(id);
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public List<Shape> getShapesWithType(String shapeType) {
		List<Shape> shapes = getAllShapes();
		List<Shape> filteredShapes = new ArrayList<>();

		for (Shape shape : shapes) {
			String className = shape.getClass().getSimpleName();
			if (className.toLowerCase().equals(shapeType.toLowerCase())) {
				filteredShapes.add(shape);
			}
		}
		return filteredShapes;
	}

	public List<Shape> getAllShapes() {
		return shapes;
	}

}
