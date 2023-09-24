package oleksii.leheza.java.lab4.entities.vehicle;

import java.util.Collection;
import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Human;

public class Bus<T extends Human> extends Vehicle<T> {

	public Bus(int maxSeatsNumber, List<T> passengers) {
		super(maxSeatsNumber, passengers);
	}

	public Bus(int maxSeatsNumber) {
		super(maxSeatsNumber);
	}

	public void carryPassengers(Collection<T> passengers) {
		System.out.println("Passengers:");
		for (Human passenger : passengers) {
			System.out.println(passenger);
		}
	}
}
