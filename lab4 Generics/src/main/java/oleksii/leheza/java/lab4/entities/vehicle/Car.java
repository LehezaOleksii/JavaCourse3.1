package oleksii.leheza.java.lab4.entities.vehicle;

import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Human;

public abstract class Car<T extends Human> extends Vehicle<T> {

	public Car(int maxSeatsNumber, List<T> passengers) {
		super(maxSeatsNumber, passengers);
	}

	public Car(int maxSeatsNumber) {
		super(maxSeatsNumber);
	}

}
