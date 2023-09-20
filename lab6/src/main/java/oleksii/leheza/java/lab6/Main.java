package oleksii.leheza.java.lab6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Translator translator = new TranslatorWithPhrase();
		translator.addNewWord("hello", "привіт");
		translator.addNewWord("world", "світ");
		String stringToTranslate = "hello world";
		System.out.println(translator.translate(stringToTranslate));
		String stringToTranslate2 = "hello world !!! word";
		System.out.println(translator.translate(stringToTranslate2));

		Scanner console = new Scanner(System.in);
		System.out.print("Input text:");
		String inputString = console.nextLine();
		while (!inputString.equalsIgnoreCase("E")) {
			if (inputString.equalsIgnoreCase("add")) {
				System.out.println("---start adding new word---");
				System.out.print("Input first word:");
				String firstWord = console.nextLine();
				System.out.print("Input second word:");
				String secondWord = console.nextLine();
				translator.addNewWord(firstWord, secondWord);
				System.out.println("---end adding new word---");
			} else {
				System.out.println("---translate start---");
				System.out.println(translator.translate(inputString));
				System.out.println("---translate end---");
				System.out.println(System.lineSeparator());
			}
			System.out.print("Input text:");
			inputString = console.nextLine();
		}
		console.close();
		System.out.print("end program");
	}
}
