package oleksii.leheza.java.lab4.entities.vehicle;

import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Fireman;

public class FireTruck<T extends Fireman> extends Car<T> {

	public FireTruck(int maxSeatsNumber, List<T> passengers) {
		super(maxSeatsNumber, passengers);
	}

	public FireTruck(int maxSeatsNumber) {
		super(maxSeatsNumber);
	}

}
