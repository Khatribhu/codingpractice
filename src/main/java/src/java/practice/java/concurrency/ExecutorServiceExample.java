package src.java.practice.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Begin");

			service.execute(() -> System.out.println("Printing Zoo inventory"));
			service.execute(() -> {
				for (int i = 0; i < 3; i++)
					System.out.println("printing record: " + i);
			});

			service.execute(() -> System.out.println("Printing Zoo inventory"));
			System.out.println("End");
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}
}
