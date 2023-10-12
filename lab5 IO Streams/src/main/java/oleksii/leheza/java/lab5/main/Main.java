package oleksii.leheza.java.lab5.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import oleksii.leheza.java.lab5.entities.Circle;
import oleksii.leheza.java.lab5.entities.Rectangle;
import oleksii.leheza.java.lab5.entities.Shape;
import oleksii.leheza.java.lab5.entities.Triangle;
import oleksii.leheza.java.lab5.filehendlers.DecryptionInputStream;
import oleksii.leheza.java.lab5.filehendlers.EncryptionOutputStream;
import oleksii.leheza.java.lab5.filehendlers.MaxWordCountLine;
import oleksii.leheza.java.lab5.filehendlers.ShapeSerializable;
import oleksii.leheza.java.lab5.filehendlers.TagFrequencyCounter;

public class Main {

	public static void main(String[] args) {
		String filename = "text.txt";
		Reader reader = new Reader();

		List<String> listStrings = reader.read(filename);
		readList(listStrings);
		// 1 task
		MaxWordCountLine maxWordCountLine = new MaxWordCountLine();
		String maxLengthLine = maxWordCountLine.getMaxWordLine(listStrings);
		System.out.println("Рядок з максимальною кількістю слів:");
		System.out.println(maxLengthLine);
		// 2 task
		ShapeSerializable seriliazable = new ShapeSerializable();
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Triangle(2, 2, 3));
		shapes.add(new Rectangle(200, 100));
		shapes.add(new Circle(10));
		String serializableFile = "serializableFile.txt";
		seriliazable.saveShapesToFile(shapes, serializableFile);
		List<Shape> readedShapes = seriliazable.readShapesFromFile(shapes, serializableFile);
		for (Shape shape : readedShapes) {
			System.out.println(shape);
		}
		// 3 task
		String fileBeforeEncryption = "fileBeforeEncryption.txt";
		String fileAfterEncryption = "fileAfterEncryption.txt";
		String fileAfterDecryption = "fileAfterDecryption.txt";
		char encryptionKey = 'A';
		try {
			FileInputStream inputFile = new FileInputStream(fileBeforeEncryption);
			EncryptionOutputStream encryptionOutputStream = new EncryptionOutputStream(
					new FileOutputStream(fileAfterEncryption), encryptionKey);

			int data;
			while ((data = inputFile.read()) != -1) {
				encryptionOutputStream.write(data);
			}

			inputFile.close();
			encryptionOutputStream.close();
			FileInputStream encryptedFile = new FileInputStream(fileAfterEncryption);
			DecryptionInputStream decryptionInputStream = new DecryptionInputStream(encryptedFile, encryptionKey);
			FileOutputStream decryptedFile = new FileOutputStream(fileAfterDecryption);

			while ((data = decryptionInputStream.read()) != -1) {
				decryptedFile.write(data);
			}

			encryptedFile.close();
			decryptedFile.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		// 4 task
		String url = "https://www.ukr.net/";
		TagFrequencyCounter tagFrequencyCounter = new TagFrequencyCounter();
		tagFrequencyCounter.printIdenticalTags(url);
	}

	public static void readList(List<String> listStrings) {
		for (String line : listStrings) {
			System.out.println(line);
		}

	}
}
