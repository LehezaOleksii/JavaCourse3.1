package oleksii.leheza.java.lab3.entities.services;

import java.util.Comparator;

import oleksii.leheza.java.lab3.entities.Shape;

public class AreaComparator implements Comparator<Shape> {
	@Override
	public int compare(Shape shape1, Shape shape2) {
		return Double.compare(shape1.calcArea(), shape2.calcArea());
	}
}