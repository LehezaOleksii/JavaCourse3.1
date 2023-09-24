package oleksii.leheza.java.lab6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslatorSimple implements Translator {

	private static String SPACE = " ";

	private Map<String, String> vocabulary;

	public TranslatorSimple() {
		vocabulary = new HashMap<>();
	}

	public void addNewWord(String firstLanguage, String secondLanguage) {
		vocabulary.put(firstLanguage, secondLanguage);
	}

	public String translate(String inputText) {
		StringBuilder translatedText = new StringBuilder();
		List<String> text = Arrays.stream(inputText.split(SPACE)).map(String::toLowerCase).toList();
		for (String englishWord : text) {
			if (vocabulary.containsKey(englishWord)) {
				translatedText.append(vocabulary.get(englishWord));
			} else {
				translatedText.append(englishWord);
			}
			translatedText.append(SPACE);
		}
		return translatedText.toString();
	}

}