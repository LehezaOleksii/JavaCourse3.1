package oleksii.leheza.java.lab9.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oleksii.leheza.java.lab9.entities.Account;
import oleksii.leheza.lab9.bank.Bank;

public class Main {

	public static void main(String[] args) {
		int numAccounts = 100;
		int initialBalance = 1000;

		List<Account> accounts = new ArrayList<>();
		for (int i = 0; i < numAccounts; i++) {
			accounts.add(new Account(i, initialBalance));
		}
		printAccountsBalances(accounts);

		Bank bank = new Bank(accounts);
		int numThreads = 1000;
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < numThreads; i++) {
			Thread thread = new Thread(() -> {
				Random random = new Random();
				int from = random.nextInt(numAccounts);
				int to = random.nextInt(numAccounts);
				int amount = random.nextInt(100);
				bank.transfer(accounts.get(from), accounts.get(to), amount);
			});
			threads.add(thread);
			thread.start();
		}

		// Чекаємо завершення всіх потоків
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Підраховуємо загальний баланс на всіх рахунках
		System.out.println("\n\n-----------------------\n\n");
		printAccountsBalances(accounts);
		int totalBalance = bank.getTotalBalance();
		System.out.println("Загальний баланс: " + totalBalance);
	}

	public static void printAccountsBalances(List<Account> accounts) {
		for (Account account : accounts) {
			System.out.println("Рахунок " + account.getId() + ": " + account.getBalance());
		}
	}
}