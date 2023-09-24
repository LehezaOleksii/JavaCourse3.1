package oleksii.leheza.java.lab2;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) {
		String firstName = "Oleksii";
		String lastName = "Leheza";
		int age = 19;
		Person person = new Person(firstName, lastName, age);
		System.out.println(person);
		Gson gson = new Gson();
		String jsonPerson = gson.toJson(person);
		System.out.println(jsonPerson);
		Person deserializedPerson = gson.fromJson(jsonPerson, Person.class);
		System.out.println(deserializedPerson);
		System.out.println("Is objects equal: " + person.equals(deserializedPerson));
	}
}
