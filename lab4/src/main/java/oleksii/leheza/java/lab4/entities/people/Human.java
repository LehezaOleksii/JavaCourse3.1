package oleksii.leheza.java.lab4.entities.people;

public class Human {

	private String name;
	private int id;

	public Human(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", id=" + id + "]";
	}
}
