package com.coding.practice.java.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinClassExample {

	public static void main(String[] args) {
		Double[] weights = new Double[10];
		ForkJoinTask<?> task = new WeightAnimalAction(weights, 0, weights.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);

		// print results
		System.out.println();
		System.out.println("weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue()+" "));
	}

}

class WeightAnimalAction extends RecursiveAction {
	private int start;
	private int end;
	private Double[] weights;

	public WeightAnimalAction(Double[] weights, int start, int end) {
		this.end = end;
		this.start = start;
		this.weights = weights;
	}

	@Override
	protected void compute() {
		if (end - start <= 3) {
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(1000);
				System.out.println("Animal weighed: " + i);
			}
		} else {
			int middle = start + (end - start) / 2;
			System.out.println("[start=" + start + ",middle=" + middle + ",end=" + end + "]");
			invokeAll(new WeightAnimalAction(weights, start, middle), new WeightAnimalAction(weights, middle, end));
		}
	}
}
