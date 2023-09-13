package oleksii.leheza.java.lab1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StringFormatter StringFormatter = new StringFormatter();
		Scanner console = new Scanner(System.in);
		System.out.print("Input text:");
		String inputText = console.nextLine();
		String[] result = StringFormatter.getWordsInIncreasingOrder(inputText);
		System.out.println("---reuslt---");
		for (String word : result) {
			System.out.println(word);
		}
		console.close();
	}
}