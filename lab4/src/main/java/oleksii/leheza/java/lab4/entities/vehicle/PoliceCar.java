package oleksii.leheza.java.lab4.entities.vehicle;

import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Policeman;

public class PoliceCar extends Car<Policeman> {

	public PoliceCar(int maxSeatsNumbers) {
		super(maxSeatsNumbers);
	}

	public PoliceCar(int maxSeatsNumber, List<Policeman> passengers) {
		super(maxSeatsNumber, passengers);
	}
}
