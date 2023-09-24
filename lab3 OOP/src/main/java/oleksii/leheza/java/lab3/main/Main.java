package oleksii.leheza.java.lab3.main;

import oleksii.leheza.java.lab3.view.View;

public class Main {

	public static void main(String[] args) {
		View view = new View();
		System.out.println("------------------All shapes------------------");
		view.showShapes();
		System.out.println("------------------Total shapes area------------------");
		view.showTotalArea();
		System.out.println("------------------All Triangles area------------------");
		view.showOneFigureTypeAreas("Triangle");
		System.out.println("------------------All Rectangles area------------------");
		view.showOneFigureTypeAreas("Rectangle");
		System.out.println("------------------All Circles area------------------");
		view.showOneFigureTypeAreas("Circle");
		System.out.println("------------------Shapes sorted by color------------------ ");
		view.showSortedShapesByColor();
		System.out.println("------------------Shapes sorted by area------------------");
		view.showSortedShapesByArea();
	}
}
