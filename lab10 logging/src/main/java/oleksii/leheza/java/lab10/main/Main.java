package oleksii.leheza.java.lab10.main;

import java.util.ArrayList;
import java.util.List;

import oleksii.leheza.java.lab10.entities.Circle;
import oleksii.leheza.java.lab10.entities.Rectangle;
import oleksii.leheza.java.lab10.entities.Shape;
import oleksii.leheza.java.lab10.entities.Triangle;
import oleksii.leheza.java.lab10.filehendlers.ShapeSerializable;

public class Main {

	public static void main(String[] args) {
		MyLogger.logInfo("RunApplication");
		MyLogger.logInfo("Create shapes list");
		ShapeSerializable serializable = new ShapeSerializable();
		List<Shape> shapes = new ArrayList<>();
		MyLogger.logInfo("Add shape to list");
		shapes.add(new Triangle(2, 2, 3));
		shapes.add(new Rectangle(200, 100));
		shapes.add(new Circle(10));
		MyLogger.logInfo("Shapes was added to the list");
		String serializableFile = "serializableFile.txt";

		MyLogger.logInfo("Saving shapes to file");
		serializable.saveShapesToFile(shapes, serializableFile);

		MyLogger.logInfo("Reading objects from file " + serializableFile);
		List<Shape> readShapes = serializable.readShapesFromFile(shapes, serializableFile);

		MyLogger.logInfo("Print readed objects from file " + serializableFile);
		for (Shape shape : readShapes) {
			System.out.println(shape);
		}

		MyLogger.logInfo("End program");
	}
}