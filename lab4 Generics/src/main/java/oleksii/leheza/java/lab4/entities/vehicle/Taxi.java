package oleksii.leheza.java.lab4.entities.vehicle;

import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Human;

public class Taxi<T extends Human> extends Car<T> {

	public Taxi(int maxSeatsNumbers) {
		super(maxSeatsNumbers);
	}

	public Taxi(int maxSeatsNumber, List<T> passengers) {
		super(maxSeatsNumber, passengers);
	}
//
//	public void carryPassengers(Collection<T> passengers) {
//		System.out.println("Passengers:");
//		for (Human passenger : passengers) {
//			System.out.println(passenger);
//		}
//	}
}
