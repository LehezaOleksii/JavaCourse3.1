package oleksii.leheza.java.lab7;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class StringHandlerTest {

	StringHandler stringHandler = new StringHandler();

	@Test
	void getWordsInIncreasingOrder_text_arrayWithWordsInIncreasingOrder() {
		String[] expectedArray = new String[1];
		expectedArray[0] = "abc";
		String text = "abc";
		assertArrayEquals(expectedArray, stringHandler.getWordsInIncreasingOrder(text));
	}

	@Test
	void getWordsInIncreasingOrder_text_arrayWithWordsInIncreasingOrder1() {
		String[] expectedArray = new String[3];
		expectedArray[0] = "abcd";
		expectedArray[1] = "ab";
		expectedArray[2] = "abc";
		String text = "abcd ab abc";
		assertArrayEquals(expectedArray, stringHandler.getWordsInIncreasingOrder(text));
	}

	@Test
	void getWordsInIncreasingOrder_text_arrayWithWordsInIncreasingOrder2() {
		String[] expectedArray = new String[2];
		expectedArray[0] = "abcd";
		expectedArray[1] = "abc";
		String text = "abcd aCb abc";
		assertArrayEquals(expectedArray, stringHandler.getWordsInIncreasingOrder(text));
	}

	@Test
	void getWordsInIncreasingOrder_stringWithSpacesBeforeText_arrayWithWordsInIncreasingOrder() {
		String[] expectedArray = new String[1];
		expectedArray[0] = "tx";
		String text = "  tx";
		assertArrayEquals(expectedArray, stringHandler.getWordsInIncreasingOrder(text));
	}

	@Test
	void getWordsInIncreasingOrder_stringWithSpacesAfterText_arrayWithWordsInIncreasingOrder() {
		String[] expectedArray = new String[1];
		expectedArray[0] = "tx";
		String text = "tx  ";
		assertArrayEquals(expectedArray, stringHandler.getWordsInIncreasingOrder(text));
	}

	@Test
	void getWordsInIncreasingOrder_stringWithSpacesBeforeAndAfterText_arrayWithWordsInIncreasingOrder() {
		String[] expectedArray = new String[1];
		expectedArray[0] = "tx";
		String text = "   tx   ";
		assertArrayEquals(expectedArray, stringHandler.getWordsInIncreasingOrder(text));
	}

	@Test
	void getWordsInIncreasingOrder_oneLetterString_arrayWithoutElements() {
		String[] expectedArray = new String[0];
		String text = "a";
		assertArrayEquals(expectedArray, stringHandler.getWordsInIncreasingOrder(text));
	}

	@Test
	void getWordsInIncreasingOrder8_emptyString_arrayWithoutElements() {
		String[] expectedArray = new String[0];
		String text = "";
		assertArrayEquals(expectedArray, stringHandler.getWordsInIncreasingOrder(text));
	}

	@Test
	void getWordsInIncreasingOrder_null_null() {
		String text = null;
		assertNull(stringHandler.getWordsInIncreasingOrder(text));
	}

}
