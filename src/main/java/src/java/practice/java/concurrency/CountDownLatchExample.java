package src.java.practice.java.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

}

class TestHarness {
	public long timeTask(int nThreads, final Runnable task) throws InterruptedException {
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);

		for (int i = 0; i < nThreads; i++) {
			Thread t = new Thread() {
				public void run() {
					try {
						startGate.wait();
						try {
							task.run();
						} finally {
							endGate.countDown();
						}
					} catch (InterruptedException ignored) {

					}
				}
			};

			t.start();
		}

		long start = System.nanoTime();
		startGate.countDown();
		endGate.await();
		long end = System.nanoTime();
		return (long) (end - start);
	}
	
}