package oleksii.leheza.java.lab8;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class ParallelMonteCarloPi {

	public void calculatePi(int numThreads, long iterations, AtomicLong inCircle) {

		Thread[] threads = new Thread[numThreads];

		for (int i = 0; i < numThreads; i++) {
			threads[i] = new Thread(() -> {
				long insideCircle = 0;
				ThreadLocalRandom random = ThreadLocalRandom.current();

				for (long j = 0; j < iterations / numThreads; j++) {
					double x = random.nextDouble();
					double y = random.nextDouble();
					double distance = x * x + y * y;

					if (distance <= 1.0) {
						insideCircle++;
					}
				}

				inCircle.addAndGet(insideCircle);
			});
			threads[i].start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}