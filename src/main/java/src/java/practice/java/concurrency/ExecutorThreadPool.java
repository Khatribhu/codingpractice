package src.java.practice.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorThreadPool {

	private AtomicInteger sheepCount = new AtomicInteger(0);

	private void incrementAndReport() {
		synchronized (this) {
			System.out.println(sheepCount.incrementAndGet());
		}
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(20);

			ExecutorThreadPool pool = new ExecutorThreadPool();
			for (int i = 0; i < 10; i++) {
				service.submit(() -> pool.incrementAndReport());
			}
		} finally {
			if (service != null)
				service.shutdownNow();
		}
	}
}
