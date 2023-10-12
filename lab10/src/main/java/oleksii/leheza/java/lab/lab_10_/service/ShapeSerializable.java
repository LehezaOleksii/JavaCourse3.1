package oleksii.leheza.java.lab.lab_10_.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import oleksii.leheza.java.lab.lab_10_.entities.Shape;
import oleksii.leheza.java.lab.lab_10_.main.MyLogger;

public class ShapeSerializable {

	public void saveShapesToFile(List<Shape> shapes, String filename) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
			outputStream.writeObject(shapes);
			MyLogger.logInfo("Shapes has been saved");
		} catch (IOException e) {
			System.err.println("Error in while shapes saving " + e.getMessage());
		}
	}

	public List<Shape> readShapesFromFile(List<Shape> shapes, String filename) {
		List<Shape> loadedShapes = new ArrayList<>();
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
			loadedShapes = (List<Shape>) inputStream.readObject();
			MyLogger.logInfo("Shapes has been readed");
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error in while shapes reading " + e.getMessage());
		}
		return loadedShapes;
	}

}
