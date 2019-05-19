package com.coding.practice.sorting;

public class TimSort {

	static int RUN = 32;

	public static void main(String[] args) {

		int arr[] = { 5, 21, 7, 23, 19, 5, 21, 7, 23, 19, 5, 21, 7, 23, 19, 5, 21, 7, 23, 19, 5, 21, 7, 23, 19, 5, 21,
				7, 23, 19, 5, 21, 7, 23, 19, 5, 21, 7, 23, 19, 5, 21, 7, 23, 19, 5, 21, 7, 23, 19, 5, 21, 7, 23, 19, };
		int n = (arr.length);
		System.out.println("Given Array is\n");
		printArray(arr);
		timSort(arr, n );
		System.out.println();
		System.out.println("After sorting Array is\n");
		printArray(arr);
	}

	/**
	 * Simple insertion sort to sort the data between range given left and right.
	 * 
	 */
	public static void insertionSort(int arr[], int left, int right) {

		for (int i = left + 1; i <= right; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= left && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	/**
	 * Merge two sorted parts of the array.
	 */
	public static void merge(int arr[], int l, int m, int r) {
		int len1 = m - l + 1;
		int len2 = r - m;

		int[] left = new int[len1];
		int[] right = new int[len2];

		for (int i = 0; i < left.length; i++) {
			left[i] = arr[i + l];
		}

		for (int i = 0; i < right.length; i++) {
			right[i] = arr[m + i + 1];
		}

		int i = 0;
		int j = 0;
		int k = l;

		// after comparing, we merge those two array
		// in larger sub array
		while (i < len1 && j < len2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		// copy remaining elements of left, if any
		while (i < len1) {
			arr[k] = left[i];
			k++;
			i++;
		}

		// copy remaining element of right, if any
		while (j < len2) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * iterative tim sort function to sort the array.
	 * 
	 * @param arr
	 * @param n
	 */
	public static void timSort(int arr[], int n) {

		// sort individual arrays of size RUN
		for (int i = 0; i < n; i += RUN) {
			insertionSort(arr, i, Math.min(i + 31, n - 1));
		}

		// start merging from size RUN. or 32.
		// it will merge to form size of 32, 64, 128, 256 so on.
		for (int size = RUN; size < n; size *= 2) {

			// pick starting point of left sub array. We
			// are going to merge arr[left..left+size-1]
			// and arr[left+size, left+2*size-1]
			// After every merge, we increase left by 2*size
			for (int left = 0; left < n; left += 2 * size) {

				// find ending point of left sub array
				// mid+1 is starting point of right sub array
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (n - 1));

				// merge sub array arr[left.....mid] &
				// arr[mid+1....right]
				merge(arr, left, mid, right);
			}
		}
	}
}
