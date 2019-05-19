package src.java.practice.java.concurrency;

import java.util.function.Supplier;

public class ReentrantLockExample {

	public static synchronized void main(String[] args) {
		LoggingWidget obj = new LoggingWidget();
		obj.doSomething();
	}
	
}

class Widget {
	public synchronized void doSomething() {
		System.out.println("Doing something...");
	}
}

class LoggingWidget extends Widget {
	
	@Override
	public synchronized void doSomething() {
		System.out.println("I have done something");
		super.doSomething();
	}
	
}
