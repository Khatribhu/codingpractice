package src.java.practice.sorting;

import java.util.Random;

public class BucketSort {
	
	static int[] sort(int[] arr, int maxValue) {
		// Bucket Sort
		int[] Bucket = new int[maxValue + 1];
		int[] sortedArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++)
			Bucket[arr[i]]++;

		int outPos = 0;
		for (int i = 0; i < Bucket.length; i++)
			for (int j = 0; j < Bucket[i]; j++)
				sortedArr[outPos++] = i;

		return sortedArr;
	}

	static void printArr(int[] sorted_sequence) {
		for (int i = 0; i < sorted_sequence.length; i++)
			System.out.print(sorted_sequence[i] + " ");
	}

	static int maxValue(int[] sequence) {
		int maxValue = 0;
		for (int i = 0; i < sequence.length; i++)
			if (sequence[i] > maxValue)
				maxValue = sequence[i];
		return maxValue;
	}

	public static void main(String args[]) {
		System.out.println("Sorting of randomly generated numbers using BUCKET SORT");
		Random random = new Random();
		int N = 20;
		int[] sequence = new int[N];

		for (int i = 0; i < N; i++)
			sequence[i] = Math.abs(random.nextInt(100));

		int maxValue = maxValue(sequence);

		System.out.println("\nOriginal Sequence: ");
		printArr(sequence);

		System.out.println("\nSorted Sequence: ");
		printArr(sort(sequence, maxValue));
	}
}