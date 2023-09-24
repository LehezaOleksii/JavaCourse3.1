package oleksii.leheza.java.lab5.filehendlers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import oleksii.leheza.java.lab5.entities.Shape;

public class ShapeSerializable {

	public void saveShapesToFile(List<Shape> shapes, String filename) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
			outputStream.writeObject(shapes);
			System.out.println("Об'єкти збережено в файл " + filename);
		} catch (IOException e) {
			System.err.println("Помилка при збереженні об'єктів: " + e.getMessage());
		}
	}

	public List<Shape> readShapesFromFile(List<Shape> shapes, String filename) {
		List<Shape> loadedShapes = new ArrayList<>();
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
			loadedShapes = (List<Shape>) inputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Помилка при читанні об'єктів: " + e.getMessage());
		}
		return loadedShapes;
	}

}
