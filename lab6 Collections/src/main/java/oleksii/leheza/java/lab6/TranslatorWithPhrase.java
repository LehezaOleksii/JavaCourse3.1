package oleksii.leheza.java.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranslatorWithPhrase implements Translator {

	private static String SPACE = " ";

	private Map<String, String> vocabulary;

	public TranslatorWithPhrase() {
		vocabulary = new HashMap<>();
	}

	public void addNewWord(String firstLanguage, String secondLanguage) {
		vocabulary.put(firstLanguage, secondLanguage);
	}

	public String translate(String inputText) {
		int maxPhraseLength = 5;
		StringBuilder translatedText = new StringBuilder();
		List<String> text = Arrays.stream(inputText.split(SPACE)).map(String::toLowerCase).toList();

		translatedWords(text, translatedText, maxPhraseLength);
		return translatedText.toString();
	}

	private List<Integer> translatedWords(List<String> text, StringBuilder translatedText, int maxPhraseLength) {
		List<Integer> translatedWords = new ArrayList<>();
		for (int i = 0; i < text.size(); i++) {
			for (int j = maxPhraseLength; j > 0; j--) {
				if (j <= text.size() && i < j && j - i > 1) {
					String translatedWord = String.join(SPACE, text.subList(i, j));
					if (vocabulary.containsKey(translatedWord)) {
						translatedText.append(vocabulary.get(translatedWord));
						translatedText.append(SPACE);
						for (int k = i + 1; k <= j; k++) {
							translatedWords.add(k);
						}
						break;
					} else {

					}
				}
			}
			if (!translatedWords.contains(i + 1)) {
				String word = text.get(i);
				translateWord(word, translatedText);
			}
		}
		return translatedWords;
	}

	private void translateWord(String word, StringBuilder translatedText) {
		if (vocabulary.containsKey(word)) {
			translatedText.append(vocabulary.get(word));
		} else {
			translatedText.append(word);
		}
		translatedText.append(SPACE);
	}
}
