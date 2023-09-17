package oleksii.leheza.java.lab7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		StringHandler stringHandler = new StringHandler();
		Scanner console = new Scanner(System.in);
		System.out.print("Input text:");
		String inputText = console.nextLine();
		String[] result = stringHandler.getWordsInIncreasingOrder(inputText);
		System.out.println("---reuslt---");
		for (String word : result) {
			System.out.println(word);
		}
		console.close();
	}
}
