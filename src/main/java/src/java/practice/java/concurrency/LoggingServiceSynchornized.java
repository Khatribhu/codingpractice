package src.java.practice.java.concurrency;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LoggingServiceSynchornized {

}

class LogWriter {
	private final BlockingQueue<String> queue;
	private final LoggerThread logger;
	private final int CAPACITY = 100;

	public LogWriter(PrintWriter writer) {
		this.queue = new LinkedBlockingQueue<String>(CAPACITY);
		this.logger = new LoggerThread(writer);
	}

	public void start() {
		logger.start();
	}

	public void log(String message) throws InterruptedException {
		queue.put(message);
	}

	private class LoggerThread extends Thread {
		private final PrintWriter writer;

		public LoggerThread(PrintWriter writer) {
			this.writer = writer;
		}

		public void run() {
			try {
				while(true) {
					writer.println(queue.take());
				}
			} catch(InterruptedException e) {
				
			} finally {
				writer.close();
			}
		}
	}
}
