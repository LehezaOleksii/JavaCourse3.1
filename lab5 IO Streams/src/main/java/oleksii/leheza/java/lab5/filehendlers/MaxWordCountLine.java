package oleksii.leheza.java.lab5.filehendlers;

import java.util.Iterator;
import java.util.List;

public class MaxWordCountLine {

	public String getMaxWordLine(List<String> strings) {

		String maxWordCountLine = "";
		String line;
		int maxWordCount = 0;

		Iterator<String> iterator = strings.iterator();
		while (iterator.hasNext()) {
			line = iterator.next();
			String[] words = line.split(" "); // Розділяємо рядок на слова за пробілами
			int wordCount = words.length;
			if (wordCount > maxWordCount) {
				maxWordCount = wordCount;
				maxWordCountLine = line;
			}
		}
		return maxWordCountLine;
	}
}