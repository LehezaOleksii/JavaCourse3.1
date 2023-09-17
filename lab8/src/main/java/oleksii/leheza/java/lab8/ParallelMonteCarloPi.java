package oleksii.leheza.java.lab8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public class ParallelMonteCarloPi {

	public int method(int numThreads, long iterations, AtomicLong inCircle, ExecutorService executor) {
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
		return numThreads;
	}
}