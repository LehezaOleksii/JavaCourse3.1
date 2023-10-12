package oleksii.leheza.java.lab.lab_10_.service;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationManager {
	private static ResourceBundle messages;

	public static void setLocale(Locale locale) {
		messages = ResourceBundle.getBundle("location/messages", locale);
	}

	public static String getMessage(String key) {
		return messages.getString(key);
	}
}
