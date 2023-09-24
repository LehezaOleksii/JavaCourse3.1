package oleksii.leheza.java.lab7;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringHandler {

	public static final String DELIMITER = "\\s+";

	public String[] getWordsInIncreasingOrder(String inputText) {
		return (inputText == null) ? null
				: Arrays.stream(inputText.trim().split(DELIMITER)).filter(this::isWordInIncreasingOrder)
						.collect(Collectors.toList()).toArray(new String[0]);
	}

	private boolean isWordInIncreasingOrder(String word) {
		return word.length() > 1
				&& IntStream.range(1, word.length()).allMatch(i -> word.charAt(i) > word.charAt(i - 1));
	}
}
