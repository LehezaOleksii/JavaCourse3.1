package oleksii.leheza.java.lab4.entities.vehicle;

import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Fireman;

public class FireTruck extends Car<Fireman> {

	public FireTruck(int maxSeatsNumber, List<Fireman> passengers) {
		super(maxSeatsNumber, passengers);
	}

	public FireTruck(int maxSeatsNumber) {
		super(maxSeatsNumber);
	}

}
