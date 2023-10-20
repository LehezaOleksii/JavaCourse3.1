package oleksii.leheza.java.lab9.service;

import java.util.concurrent.BlockingQueue;

public class Translator implements Runnable {
	private int id;
	private BlockingQueue<String> buffer;

	public Translator(int id, BlockingQueue<String> buffer) {
		this.id = id;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			while (true) {
				String message = buffer.take();
				String translatedMessage = "Потік №" + id + " переклав повідомлення "
						+ message.split(" ")[message.split(" ").length - 1];
				buffer.put(translatedMessage);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}