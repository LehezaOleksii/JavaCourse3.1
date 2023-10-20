package oleksii.leheza.java.lab9.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import oleksii.leheza.java.lab9.entities.Account;
import oleksii.leheza.java.lab9.service.Producer;
import oleksii.leheza.java.lab9.service.Translator;
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

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\n\n-----------------------\n\n");
		printAccountsBalances(accounts);
		int totalBalance = bank.getTotalBalance();
		System.out.println("Загальний баланс: " + totalBalance);
		// ----------------task2------------------
		BlockingQueue<String> buffer = new ArrayBlockingQueue<>(10);

		Thread[] producerThreads = new Thread[5];
		Thread[] translatorThreads = new Thread[2];

		// Create and start producer threads
		for (int i = 0; i < 5; i++) {
			producerThreads[i] = new Thread(new Producer(i, buffer));
			producerThreads[i].setDaemon(true);
			producerThreads[i].start();
		}

		// Create and start translator threads
		for (int i = 0; i < 2; i++) {
			translatorThreads[i] = new Thread(new Translator(i, buffer));
			translatorThreads[i].setDaemon(true);
			translatorThreads[i].start();
		}

		// Main thread reads and prints 100 messages from the buffer
		for (int i = 0; i < 100; i++) {
			try {
				String message = buffer.take();
				System.out.println(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void printAccountsBalances(List<Account> accounts) {
		for (Account account : accounts) {
			System.out.println("Рахунок " + account.getId() + ": " + account.getBalance());
		}
	}
}