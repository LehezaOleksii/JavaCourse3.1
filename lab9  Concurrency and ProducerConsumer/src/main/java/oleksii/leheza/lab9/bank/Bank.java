package oleksii.leheza.lab9.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import oleksii.leheza.java.lab9.entities.Account;

public class Bank {
	private List<Account> accounts;
	private List<Lock> accountLocks;

	public Bank(List<Account> accounts) {
		this.accounts = accounts;
		this.accountLocks = new ArrayList<>();

		for (int i = 0; i < accounts.size(); i++) {
			accountLocks.add(new ReentrantLock());
		}
	}

	public void transfer(Account from, Account to, int amount) {
		int fromIndex = from.getId();
		int toIndex = to.getId();

		if (fromIndex == toIndex) {
			return;
		}

		int firstLockIndex = Math.min(fromIndex, toIndex);
		int secondLockIndex = Math.max(fromIndex, toIndex);

		accountLocks.get(firstLockIndex).lock();
		accountLocks.get(secondLockIndex).lock();

		try {
			from.withdraw(amount);
			to.deposit(amount);
		} finally {
			accountLocks.get(secondLockIndex).unlock();
			accountLocks.get(firstLockIndex).unlock();
		}
	}

	public int getTotalBalance() {
		return accounts.stream().mapToInt(Account::getBalance).sum();
	}
}