package oleksii.leheza.java.lab8;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

	public static void main(String[] args) {

		int numThreads = 1;
		long iterations = 1000000000L;
		AtomicLong inCircle = new AtomicLong(0);
		ParallelMonteCarloPi parallelMonthCarloPi = new ParallelMonteCarloPi();
		long startTime = System.currentTimeMillis();
		parallelMonthCarloPi.calculatePi(numThreads, iterations, inCircle);
		long endTime = System.currentTimeMillis();
		double pi = (4.0 * inCircle.get()) / iterations;

		System.out.println("PI is " + pi);
		System.out.println("THREADS " + numThreads);
		System.out.println("ITERATIONS " + iterations);
		System.out.println("TIME " + (endTime - startTime) + "ms");
	}
}
