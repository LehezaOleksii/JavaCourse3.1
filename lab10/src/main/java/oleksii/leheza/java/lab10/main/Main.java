package oleksii.leheza.java.lab10.main;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Interzialization.Internationalization;
import oleksii.leheza.java.lab10.entities.Circle;
import oleksii.leheza.java.lab10.entities.Rectangle;
import oleksii.leheza.java.lab10.entities.Shape;
import oleksii.leheza.java.lab10.entities.Triangle;
import oleksii.leheza.java.lab10.filehendlers.ShapeSerializable;

public class Main {

	public static void main(String[] args) {
		// Створюємо та ініціалізуємо рядок
		String strLiteral = "Hello, world!";
		String strInput = getInputString();

		// Виводимо рядок до зміни
		System.out.println("Before reflection:");
		System.out.println("strLiteral: " + strLiteral);
		System.out.println("strInput: " + strInput);

		// Використовуємо рефлексію для зміни значення рядка
		try {
			// Отримуємо поле value
			Field valueField = String.class.getDeclaredField("value");
			valueField.setAccessible(true);

			// Змінюємо значення рядка
			valueField.set(strLiteral, "New value for strLiteral".toCharArray());
			valueField.set(strInput, "New value for strInput".toCharArray());

		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}

		// Виводимо рядок після зміни
		System.out.println("\nAfter reflection:");
		System.out.println("strLiteral: " + strLiteral);
		System.out.println("strInput: " + strInput);
//		task 2

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

//    task 3 
		Internationalization internialization = new Internationalization();

		internialization.internationalizationStart();
	}

	private static String getInputString() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		return scanner.nextLine();
	}
}