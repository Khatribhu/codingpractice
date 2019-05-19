package com.coding.practice.sorting;

public class SelectionSortStable {

	/**
	 * swapping elements in the array makes selection sort unstable hence if we push
	 * array one elemnt forward after finding min element
	 * 
	 * @param arr
	 */
	public static void stableSSort(int[] arr) {
		int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			// find min element from i to n-1
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}

			// move the element at current i.
			int key = arr[min];
			while (min > i) {
				arr[min] = arr[min - 1];
				min--;
			}

			arr[i] = key;
		}
	}
	
}
