package oleksii.leheza.java.lab8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

	public static void main(String[] args) {

		int numThreads = 4;
		long iterations = 10000000L;
		AtomicLong inCircle = new AtomicLong(0);

		ExecutorService executor = Executors.newFixedThreadPool(numThreads);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < numThreads; i++) {
			executor.execute(() -> {
				long localInCircle = 0;
				for (long j = 0; j < iterations / numThreads; j++) {
					double x = Math.random();
					double y = Math.random();
					double distance = Math.sqrt(x * x + y * y);
					if (distance <= 1) {
						localInCircle++;
					}
				}
				inCircle.addAndGet(localInCircle);
			});
		}

		executor.shutdown();
		while (!executor.isTerminated()) {
		}

		long endTime = System.currentTimeMillis();
		double pi = (4.0 * inCircle.get()) / iterations;

		System.out.println("PI is " + pi);
		System.out.println("THREADS " + numThreads);
		System.out.println("ITERATIONS " + iterations);
		System.out.println("TIME " + (endTime - startTime) + "ms");
	}
}
