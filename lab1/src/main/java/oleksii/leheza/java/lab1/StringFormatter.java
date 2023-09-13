package oleksii.leheza.java.lab1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringFormatter {

	public static final String DELIMITER = "\\s+";

	public String[] getWordsInIncreasingOrder(String inputText) {
		if (inputText == null) {
			return null;
		}
		String text = inputText.trim();
		List<String> wordsInIncreasingOrder = Arrays.stream(text.split(DELIMITER)).filter(this::isWordInIncreasingOrder)
				.collect(Collectors.toList());
		return wordsInIncreasingOrder.toArray(new String[0]);
	}

	private boolean isWordInIncreasingOrder(String word) {
		return word.length() > 1
				&& IntStream.range(1, word.length()).allMatch(i -> word.charAt(i) > word.charAt(i - 1));
	}
}
