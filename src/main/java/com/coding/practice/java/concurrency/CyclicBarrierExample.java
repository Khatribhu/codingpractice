package com.coding.practice.java.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

	public static void main(String[] args) {

		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			LionPenManager manager = new LionPenManager();
			/*
			 * for (int i = 0; i < 4; i++) { service.execute(() -> manager.performTasks());
			 * }
			 */

			CyclicBarrier c1 = new CyclicBarrier(4, () -> System.out.println("*** animal removed"));
			CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("**** Pan cleared"));
			for (int i = 0; i < 4; i++) {
				service.execute(() -> manager.performTask(c1, c2));
			}
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
}

class LionPenManager {
	private void removeAnimal() {
		System.out.println("Removing animals");
	}

	private void addAnimal() {
		System.out.println("Adding animal");
	}

	private void cleanPan() {
		System.out.println("Cleaning pan");
	}

	// without cyclic barrier
	/*
	 * public void performTasks() { removeAnimal(); cleanPan(); addAnimal(); }
	 */
	public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
		try {
			removeAnimal();
			c1.await();
			cleanPan();
			c2.await();
			addAnimal();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
