package oleksii.leheza.java.lab4.main;

import java.util.ArrayList;
import java.util.List;

import oleksii.leheza.java.lab4.entities.people.Fireman;
import oleksii.leheza.java.lab4.entities.people.Human;
import oleksii.leheza.java.lab4.entities.people.Policeman;
import oleksii.leheza.java.lab4.entities.vehicle.Bus;
import oleksii.leheza.java.lab4.entities.vehicle.FireTruck;
import oleksii.leheza.java.lab4.entities.vehicle.PoliceCar;
import oleksii.leheza.java.lab4.entities.vehicle.Taxi;
import oleksii.leheza.java.lab4.entities.vehicle.Vehicle;

public class Main {

	public static void main(String[] args) {
		Vehicle<Human> bus = new Bus<>(12, getPassengersToBus());
		Vehicle<Fireman> fireTruck = new FireTruck<>(8, getPassengersToFireTruck());
		Vehicle<Policeman> policeCar = new PoliceCar<>(4, getPassengersToPoliceCar());
		Vehicle<Human> taxi = new Taxi<>(5, getPassengersToTaxi());

		bus.carryPassengers();
		fireTruck.carryPassengers();
		policeCar.carryPassengers();

		taxi.carryPassengers();
		Human newHuman = new Human("new Human 1", 0);
		taxi.getOn(newHuman);
		taxi.carryPassengers();
		taxi.getOff(newHuman);
		taxi.carryPassengers();
	}

	public static List<Policeman> getPassengersToPoliceCar() {
		List<Policeman> policemen = new ArrayList<>();
		Policeman policeman1 = new Policeman("policeman 1", 1);
		Policeman policeman2 = new Policeman("policeman 2", 2);
		Policeman policeman3 = new Policeman("policeman 3", 3);
		Policeman policeman4 = new Policeman("policeman 4", 4);
		policemen.add(policeman1);
		policemen.add(policeman2);
		policemen.add(policeman3);
		policemen.add(policeman4);
		return policemen;
	}

	public static List<Fireman> getPassengersToFireTruck() {
		List<Fireman> firemen = new ArrayList<>();
		Fireman fireman1 = new Fireman("fireman 1", 5);
		Fireman fireman2 = new Fireman("fireman 2", 6);
		Fireman fireman3 = new Fireman("fireman 3", 7);
		Fireman fireman4 = new Fireman("fireman 4", 8);
		firemen.add(fireman1);
		firemen.add(fireman2);
		firemen.add(fireman3);
		firemen.add(fireman4);
		return firemen;
	}

	public static List<Human> getPassengersToBus() {
		List<Human> passengers = new ArrayList<>();
		Human person1 = new Human("human 1", 9);
		Human person2 = new Human("human 2", 10);
		Human person3 = new Human("human 3", 11);
		Human person4 = new Human("human 4", 12);
		Human policeman1 = new Policeman("policeman 1", 13);
		Human policeman2 = new Policeman("policeman 2", 14);
		Human policeman3 = new Policeman("policeman 3", 15);
		Human policeman4 = new Policeman("policeman 4", 16);
		passengers.add(person1);
		passengers.add(person2);
		passengers.add(person3);
		passengers.add(person4);
		passengers.add(policeman1);
		passengers.add(policeman2);
		passengers.add(policeman3);
		passengers.add(policeman4);
		return passengers;
	}

	public static List<Human> getPassengersToTaxi() {
		List<Human> passengers = new ArrayList<>();
		Human person1 = new Human("human 1", 17);
		Human person2 = new Human("human 2", 18);
		Human policeman1 = new Policeman("policeman 1", 19);
		Human fireman1 = new Fireman("fireman 1", 20);
		passengers.add(person1);
		passengers.add(person2);
		passengers.add(policeman1);
		passengers.add(fireman1);
		return passengers;
	}
}
