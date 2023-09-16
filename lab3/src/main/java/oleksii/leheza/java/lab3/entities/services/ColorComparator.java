package oleksii.leheza.java.lab3.entities.services;

import java.util.Comparator;

import oleksii.leheza.java.lab3.entities.Shape;

public class ColorComparator implements Comparator<Shape> {

	@Override
	public int compare(Shape shape1, Shape shape2) {
		return shape1.getShapeColor().compareTo(shape2.getShapeColor());
	}
}
