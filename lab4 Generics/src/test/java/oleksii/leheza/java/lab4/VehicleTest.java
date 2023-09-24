package oleksii.leheza.java.lab4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import oleksii.leheza.java.lab4.entities.people.Fireman;
import oleksii.leheza.java.lab4.entities.people.Human;
import oleksii.leheza.java.lab4.entities.people.Policeman;
import oleksii.leheza.java.lab4.entities.vehicle.Bus;
import oleksii.leheza.java.lab4.entities.vehicle.FireTruck;
import oleksii.leheza.java.lab4.entities.vehicle.PoliceCar;
import oleksii.leheza.java.lab4.entities.vehicle.Taxi;
import oleksii.leheza.java.lab4.entities.vehicle.Vehicle;
import oleksii.leheza.java.lab4.exception.VehicleException;

class VehicleTest {

	// Bus test
	@Test
	void bus_allPasengers_busWithPassengers() {
		List<Human> passengers = new ArrayList<>();
		Human human = new Human("human 1", 1);
		Human policeman = new Policeman("policeman 1", 2);
		Human fireman = new Human("fireman 1", 3);
		passengers.add(human);
		passengers.add(policeman);
		passengers.add(fireman);
		Vehicle<Human> bus = new Bus<Human>(3, passengers);
		assertEquals(passengers, bus.getPassengers());
	}

	@Test
	void bus_TooMuchPassengers_ExceptionWithMessage() {
		Human human = new Human("human 1", 1);
		Human policeman = new Human("policeman 1", 2);
		Vehicle<Human> bus = new Bus<>(1);
		bus.getOn(human);
		assertThrows(VehicleException.class, () -> {
			bus.getOn(policeman);
		});
	}

	// taxi test
	@Test
	void taxi_allPasengers_taxiWithPassengers() {
		List<Human> passengers = new ArrayList<>();
		Human human = new Human("human 1", 1);
		Human policeman = new Human("policeman 1", 2);
		Human fireman = new Human("fireman 1", 3);
		passengers.add(human);
		passengers.add(policeman);
		passengers.add(fireman);
		Vehicle<Human> taxi = new Taxi<Human>(3, passengers);
		assertEquals(passengers, taxi.getPassengers());
	}

	@Test
	void taxi_TooMuchPassengers_ExceptionWithMessage() {
		Human human = new Human("human 1", 1);
		Human policeman = new Human("policeman 1", 2);
		Vehicle<Human> taxi = new Taxi<>(1);
		taxi.getOn(human);
		assertThrows(VehicleException.class, () -> {
			taxi.getOn(policeman);
		});
	}

	// police test
	@Test
	void policeCar_allPolicemenPassengers_policeCarWithPolicemen() {
		List<Policeman> passengers = new ArrayList<>();
		Policeman policeman1 = new Policeman("policeman 1", 1);
		Policeman policeman2 = new Policeman("policeman 2", 2);
		Policeman policeman3 = new Policeman("policeman 3", 3);
		passengers.add(policeman1);
		passengers.add(policeman2);
		passengers.add(policeman3);
		Vehicle<Policeman> policeCar = new PoliceCar<Policeman>(3, passengers);
		assertEquals(passengers, policeCar.getPassengers());
	}

	@Test
	void policeCar_TooMuchPassengers_exceptionWithMessage() {
		Policeman policeman1 = new Policeman("policemna 1", 1);
		Policeman policeman2 = new Policeman("policeman 2", 2);
		Vehicle<Policeman> policeCar = new PoliceCar<Policeman>(1);
		policeCar.getOn(policeman1);
		assertThrows(VehicleException.class, () -> {
			policeCar.getOn(policeman2);
		});
	}

	// firetruck test
	@Test
	void fireTruck_allFiremenPassengers_fireTruckWithFiremen() {
		List<Human> passengers = new ArrayList<>();
		Human fireman1 = new Fireman("fireman 1", 1);
		Human fireman2 = new Fireman("fireman 2", 2);
		Human fireman3 = new Fireman("fireman 3", 3);

		passengers.add(fireman1);
		passengers.add(fireman2);
		passengers.add(fireman3);

		Vehicle<Fireman> fireTruck = new FireTruck(3, passengers);
		assertEquals(passengers, fireTruck.getPassengers());
	}

	@Test
	void fireTruck_TooMuchPassengers_exceptionWithMessage() {
		Human fireman1 = new Policeman("fireman 1", 1);
		Human fireman2 = new Policeman("fireman 2", 2);
		Vehicle<Human> fireTruck = new FireTruck(1);
		fireTruck.getOn(fireman1);
		assertThrows(VehicleException.class, () -> {
			fireTruck.getOn(fireman2);
		});
	}

}
