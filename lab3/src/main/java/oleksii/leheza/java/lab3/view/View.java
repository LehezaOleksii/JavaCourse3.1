package oleksii.leheza.java.lab3.view;

import java.util.List;

import oleksii.leheza.java.lab3.controller.Controller;
import oleksii.leheza.java.lab3.entities.Shape;

public class View {

	private Controller controller;

	public View() {
		controller = new Controller();
	}

	public void showShapes() {
		List<Shape> shapes = controller.getShapes();
		for (Shape shape : shapes) {
			System.out.println(shape);
		}
	}

	public void showTotalArea() {
		System.out.println(controller.getTotalArea());
	}

	public void drawShape(int id) {
		System.out.println(controller.getShapeById(id));
	}

	public void showArea(int id) {
		System.out.println(controller.getArea(id));
	}

	public void shapesSum(int id) {
		System.out.println(controller.getShapeById(id).calcArea());
	}

	public void showOneFigureTypeAreas(String figureType) {
		List<Shape> shapes = controller.getOneFigureStylesAreas(figureType);
		for (Shape shape : shapes) {
			double shapeArea = controller.getArea(shape);
			System.out.println(shape + " area = " + shapeArea);
		}
	}

	public void showSortedShapesByArea() {
		List<Shape> sortedShapes = controller.sortByArea();
		for (Shape shape : sortedShapes) {
			double shapeArea = controller.getArea(shape);
			System.out.println(shape + " area = " + shapeArea);
		}
	}

	public void showSortedShapesByColor() {
		List<Shape> sortedShapes = controller.sortByColor();
		for (Shape shape : sortedShapes) {
			String color = shape.getShapeColor();
			System.out.println(shape + " color = " + color);
		}
	}
}
