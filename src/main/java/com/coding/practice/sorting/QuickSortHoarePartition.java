package com.coding.practice.sorting;

/**
 * Java implementation of QuickSort using Hoare's partition scheme
 *
 * @author bkhatri3
 */
public class QuickSortHoarePartition {

	public static void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		printArray(arr);
	}

	/**
	 * This function takes lowest element as pivot.
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	public static int partition(int[] arr, int low, int high) {
		// taking pivot element as lowest element.
		int pivot = arr[low];
		int i = low, j = high;
		System.out.println("input to partition:" + " low : " + low + " high: " + high);

		while (true) {

			// Find leftmost element smaller
			// than pivot
			while (arr[i] < pivot) {
				i++;
			}

			// Find rightmost element greater
			// than pivot
			while (arr[j] > pivot) {
				j--;
			}

			// if two pointers are met
			if (i >= j) {
				return j;
			}

			// find the left and right element of the pivot and swap.
			swap(arr, i, j);
		}

	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			System.out.println("pi: " + pi);
			quickSort(arr, low, pi);
			quickSort(arr, pi + 1, high);
		}
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
		printArray(arr);
	}
}
