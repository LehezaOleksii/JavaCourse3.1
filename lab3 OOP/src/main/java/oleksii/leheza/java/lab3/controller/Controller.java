package oleksii.leheza.java.lab3.controller;

import java.util.Collections;
import java.util.List;

import oleksii.leheza.java.lab3.entities.Shape;
import oleksii.leheza.java.lab3.entities.services.AreaComparator;
import oleksii.leheza.java.lab3.entities.services.ColorComparator;
import oleksii.leheza.java.lab3.model.Model;

public class Controller {

	private Model model;

	public Controller() {
		model = new Model();
	}

	public double getArea(int id) {
		Shape shape = model.getShape(id);
		return shape.calcArea();
	}

	public double getArea(Shape shape) {
		return shape.calcArea();
	}

	public void drawShape(int id) {
		Shape shape = model.getShape(id);
		shape.draw();
	}

	public List<Shape> getOneFigureStylesAreas(String figureType) {
		return model.getShapesWithType(figureType);
	}

	public List<Shape> getShapes() {
		return model.getShapes();
	}

	public double getTotalArea() {
		List<Shape> shapes = model.getAllShapes();
		double totalArea = shapes.stream().mapToDouble(Shape::calcArea).sum();
		return totalArea;
	}

	public List<Shape> sortByArea() {
		List<Shape> shapes = model.getAllShapes();
		Collections.sort(shapes, new AreaComparator());
		return shapes;
	}

	public List<Shape> sortByColor() {
		List<Shape> shapes = model.getAllShapes();
		Collections.sort(shapes, new ColorComparator());
		return shapes;
	}

	public Shape getShapeById(int id) {
		return model.getShape(id);
	}
}
