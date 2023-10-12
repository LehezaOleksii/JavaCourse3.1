package Interzialization;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internationalization {

	public void internationalizationStart() {
		Locale currentLocale = new Locale("en"); // Задайте відповідну локаль
		ResourceBundle messages = ResourceBundle.getBundle("location/strings", currentLocale);

		System.out.println(messages.getString("greeting")); // Виведення вітання
		System.out.println(messages.getString("menu.option1")); // Виведення пункту меню
	}
}
