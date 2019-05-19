package src.java.practice.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = { 12, 11, 13, 5, 6 };
		// insertionSort(array);
		insertionBinarySort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		int[] arraySort = { 7, 10, 11, 3, 6, 9, 2, 13, 0 };
	}

	/**
	 * Time complexity: O(n*n) Space: O(1)
	 * 
	 * Insertion
	 * 
	 * @param arr
	 */
	public static void insertionSort(int[] arr) {
		int size = arr.length;
		for (int i = 1; i < size; i++) {
			int key = arr[i];
			int j = i - 1;

			// move elements of array, that are greater than key to one position ahead of
			// their current position.
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return;
	}

	public static void insertionSortRecursive(int arr[], int n) {

		// base case
		if (n <= 1) {
			return;
		}

		// sort first n-1 elements.
		insertionSortRecursive(arr, n - 1);

		// insert last element at correct position.
		// in sorted array
		int last = arr[n - 1];
		int j = n - 2;

		while (j >= 0 && arr[j] > last) {
			arr[j + 1] = arr[j];
			j = j - 1;
		}
		arr[j + 1] = last;
	}

	public static void insertionBinarySort(int array[]) {

		for (int i = 1; i < array.length; i++) {
			int x = array[i];

			// Find location to insert using binary search
			int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);

			// Shifting array to one location right
			System.arraycopy(array, j, array, j + 1, i - j);

			// Placing element at its correct location
			array[j] = x;
		}
	}

	public static void sortEvenAndOddPosition(int[] array) {
		int size = array.length;
		for (int i = 2; i < size; i++) {
			int val = array[i];
			int j = i - 2;

			// checking for odd positioned.
			if (((i + 1) & 1) == 1) {
				// Inserting even positioned elements
				// in ascending order.
				while ((val >= array[j]) && j >= 0) {
					array[j + 2] = array[j];
					j -= 2;
				}
				array[j + 2] = val;
			} else { // sorting the even positioned.

				// Inserting odd positioned elements
				// in descending order.
				while (val <= array[j] && j >= 0) {
					array[j + 2] = array[j];
					j -= 2;
				}
				array[j + 2] = val;
			}
		}
	}
}
