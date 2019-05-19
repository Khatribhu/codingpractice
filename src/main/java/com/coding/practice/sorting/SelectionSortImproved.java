package com.coding.practice.sorting;

/**
 * The idea is to take min as well as max in every pass and place at right
 * position.
 * 
 * @author bkhatri3
 *
 */
public class SelectionSortImproved {
	public static void improvedSSort(int arr[]) {
		int size = arr.length;
		for (int i = 0, j = size - 1; i < j; i++, j--) {
			int minIndex = i;
			int maxIndex = i;
			int min = arr[i];
			int max = arr[i];
			for (int k = i; k <= j; k++) {
				if (arr[k] > max) {
					max = arr[k];
					maxIndex = k;
				}
				if (arr[k] < min) {
					min = arr[k];
					minIndex = k;
				}
			}

			// shifting the min element
			if (minIndex != i) {
				swap(arr, i, minIndex);
			}

			// shifting the max. the equal condition happens if we shited the max to
			// arr[minIndex] in previous swap.
			if (arr[minIndex] == max) {
				// swap j with minIndex
				swap(arr, j, minIndex);
			} else {
				// swap j with maxIndex
				swap(arr, j, maxIndex);
			}
		}
	}

	public static void swap(int arr[], int from, int to) {
		arr[from] = arr[from] + arr[to];
		arr[to] = arr[from] - arr[to];
		arr[from] = arr[from] - arr[to];
	}
}
