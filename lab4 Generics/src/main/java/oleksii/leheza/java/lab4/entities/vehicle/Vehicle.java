package oleksii.leheza.java.lab4.entities.vehicle;

import java.util.ArrayList;
import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Human;
import oleksii.leheza.java.lab4.exception.VehicleException;

public abstract class Vehicle<T extends Human> {

	private int maxSeatsNumber;
	private List<T> passengers = new ArrayList<>();

	public Vehicle(int maxSeatsNumber) {
		this.maxSeatsNumber = maxSeatsNumber;
	}

	public Vehicle(int maxSeatsNumber, List<T> passengers) {
		this.maxSeatsNumber = maxSeatsNumber;
		for (Human passenger : passengers) {
			this.getOn((T) passenger);
		}
	}

	public void carryPassengers() {
		System.out.println("----------carry passangers----------");
		for (T passanger : passengers) {
			System.out.println(passanger);
		}
	}

	public void getOn(T person) {
		if (!passengers.contains(person)) {
			if (maxSeatsNumber > passengers.size()) {
				passengers.add(person);
			} else {
				throw new VehicleException("All seats are occupied");
			}
		}
	}

	public void getOff(T person) {
		if (passengers.contains(person)) {
			passengers.remove(person);
		} else {
			throw new VehicleException("the person is not in the vehicle");
		}
	}

	public int getOccupiedSeats() {
		return passengers.size();
	}

	public int getMaxSeatsNumber() {
		return maxSeatsNumber;
	}

	public void setMaxSeatsNumber(int maxSeatsNumber) {
		this.maxSeatsNumber = maxSeatsNumber;
	}

	public List<T> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<T> passengers) {
		this.passengers = passengers;
	}

}
