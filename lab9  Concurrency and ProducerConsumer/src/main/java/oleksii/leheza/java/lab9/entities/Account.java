package oleksii.leheza.java.lab9.entities;

public class Account {

	private int id;
	private int balance;

	public Account(int id, int balance) {
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}

	public void withdraw(int amount) {
		this.balance -= amount;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}
}
