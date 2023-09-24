package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import nl.jqno.equalsverifier.EqualsVerifier;
import oleksii.leheza.java.lab2.Person;

class JsonTest {

	Gson gson = new Gson();

	@Test
	void gson_person_person() {
		String name = "firstName 1";
		String lastName = "SecondName 1";
		int age = 19;
		Person expectedPerson = new Person(name, lastName, age);
		Person person = new Person(name, lastName, age);
		String jsonPerson = gson.toJson(person);
		Person actualPerson = gson.fromJson(jsonPerson, Person.class);
		assertEquals(expectedPerson, actualPerson);
	}

	@Test
	void gson_personWithNullVariables_person() {
		String name = null;
		String lastName = null;
		Person expectedPerson = new Person(name, lastName);
		Person person = new Person(name, lastName);
		String jsonPerson = gson.toJson(person);
		Person actualPerson = gson.fromJson(jsonPerson, Person.class);
		assertEquals(expectedPerson, actualPerson);
	}

	@Test
	void gson_emptyPerson_person() {
		Person person = new Person();
		Person expectedPerson = new Person();
		String jsonPerson = gson.toJson(person);
		Person actualPerson = gson.fromJson(jsonPerson, Person.class);
		assertEquals(expectedPerson, actualPerson);
	}

	@Test
	void gson_null_null() {
		Person person = null;
		Person expectedPerson = null;
		String jsonPerson = gson.toJson(person);
		Person actualPerson = gson.fromJson(jsonPerson, Person.class);
		assertEquals(expectedPerson, actualPerson);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Person.class).verify();
	}
}
