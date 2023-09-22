package oleksii.leheza.java.lab1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringFormatter {

	public static final String DELIMITER = "\\s+";

	public String[] getWordsInIncreasingOrder(String inputText) {
		if (inputText == null) {
			return null;
		}
		String text = inputText.trim();
		return Arrays.stream(text.split(DELIMITER)).filter(this::isWordInIncreasingOrder).collect(Collectors.toList())
				.toArray(new String[0]);
	}

	private boolean isWordInIncreasingOrder(String word) {
		if (word.length() <= 1) {
			return false;
		}

		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i) <= word.charAt(i - 1)) {
				return false;
			}
		}

		return true;
	}
}
