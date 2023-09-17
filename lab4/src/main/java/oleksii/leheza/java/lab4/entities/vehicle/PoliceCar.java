package oleksii.leheza.java.lab4.entities.vehicle;

import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Policeman;

public class PoliceCar<T extends Policeman> extends Car<T> {

	public PoliceCar(int maxSeatsNumbers) {
		super(maxSeatsNumbers);
	}

	public PoliceCar(int maxSeatsNumber, List<T> passengers) {
		super(maxSeatsNumber, passengers);
	}
}
