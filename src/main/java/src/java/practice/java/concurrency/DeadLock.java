package src.java.practice.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Food {}
class Water {}
class Fox {
	public void eatAndDrink(Food food, Water water) {
		synchronized (food) {
			System.out.println("!!! Got food.");
			move();
			synchronized (water) {
				System.out.println("!!! Got water");
			}
		}
	}

	public void drinkAndEat(Food food, Water water) {
		synchronized (water) {
			System.out.println("!!! Got water");
			move();
			synchronized (food) {
				System.out.println("!!! Got Food");
			}
		}
	}

	public void move() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// handle exception
		}
	}

}

public class DeadLock {

	public static void main(String[] args) {
		// create participant
		Fox foxy = new Fox();
		Fox tails = new Fox();
		Food food = new Food();
		Water water = new Water();

		// process data.
		ExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(10);
			service.submit(() -> foxy.eatAndDrink(food, water));
			service.submit(() -> tails.drinkAndEat(food, water));
		} finally {
			if (service != null)
				service.shutdown();
		}

	}
}
