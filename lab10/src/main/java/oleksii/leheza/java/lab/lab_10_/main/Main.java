package oleksii.leheza.java.lab.lab_10_.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import oleksii.leheza.java.lab.lab_10_.entities.Circle;
import oleksii.leheza.java.lab.lab_10_.entities.Rectangle;
import oleksii.leheza.java.lab.lab_10_.entities.Shape;
import oleksii.leheza.java.lab.lab_10_.entities.Triangle;
import oleksii.leheza.java.lab.lab_10_.service.InternationalizationManager;
import oleksii.leheza.java.lab.lab_10_.service.ShapeSerializable;

public class Main {

	public static void main(String[] args) { // Створення та ініціалізація рядка літералом
		// Створення та ініціалізація рядка літералом
		StringBuilder stringBuilder = new StringBuilder("Hello, World!");

		// Ввід рядка з клавіатури
		StringBuilder inputStringBuilder = new StringBuilder(getInputString());

		// Виведення рядків до зміни
		System.out.println("Before manipulation:");
		System.out.println("stringBuilder: " + stringBuilder);
		System.out.println("inputStringBuilder: " + inputStringBuilder);

		// Зміна значення рядка, який створений літералом
		setCharAtIndex(stringBuilder, 7, 'X');

		// Зміна значення рядка, який створений введенням з клавіатури
		setCharAtIndex(inputStringBuilder, 0, 'Y');

		// Виведення рядків після зміни
		System.out.println("\nAfter manipulation:");
		System.out.println("stringBuilder: " + stringBuilder);
		System.out.println("inputStringBuilder: " + inputStringBuilder);
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
		// Вибір мови
		Locale locale = selectLocale();
		InternationalizationManager.setLocale(locale);

		System.out.println(InternationalizationManager.getMessage("greeting"));
		System.out.println(InternationalizationManager.getMessage("goodbye"));
	}

	private static void setCharAtIndex(StringBuilder stringBuilder, int index, char newChar) {
		if (index >= 0 && index < stringBuilder.length()) {
			stringBuilder.setCharAt(index, newChar);
		}
	}

	private static String getInputString() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		return scanner.nextLine();
	}

	private static Locale selectLocale() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select a language (en/gr):");
		String language = scanner.nextLine();

		if ("gr".equals(language)) {
			return new Locale("gr", "GR");
		} else {
			return new Locale("en", "US");
		}
	}
}