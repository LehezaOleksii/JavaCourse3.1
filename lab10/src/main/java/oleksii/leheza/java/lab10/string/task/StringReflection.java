package oleksii.leheza.java.lab10.string.task;

import java.util.Scanner;

public class StringReflection {
	public String getUserInput() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string: ");
		return scanner.nextLine();
	}
}