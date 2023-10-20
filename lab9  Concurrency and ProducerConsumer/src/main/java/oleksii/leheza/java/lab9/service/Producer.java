package oleksii.leheza.java.lab9.service;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private int id;
	private BlockingQueue<String> buffer;

	public Producer(int id, BlockingQueue<String> buffer) {
		this.id = id;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 100; i++) {
				String message = "Потік №" + id + " згенерував повідомлення " + i;
				buffer.put(message);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}