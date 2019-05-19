package com.coding.practice.sorting;

/**
 * Recursive sort select first n elements finds min element and place at
 * Beginning. Then compute for rest.
 * 
 * @author bkhatri3
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		SelectionSortStable selectionSortStable = new SelectionSortStable();
		SelectionSortImproved improved = new SelectionSortImproved();
		int array[] = { 1, 3, 4, 2, 2, 0 };
		// selectionSort(array);
		// recursiveSelectionSort(array, 0, array.length);
		// recursiveSS(array, array.length, 0);
		//selectionSortStable.stableSSort(array);
		improved.improvedSSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void selectionSort(int[] array) {
		int size = array.length;
		for (int i = 0; i < size; i++) {
			int minIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}

			// swap the minIndex with i;
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * recursive solution for the selection sort.
	 * 
	 * @return
	 * 
	 */
	public static void recursiveSelectionSort(int[] array, int index, int size) {

		if (index == size) {
			return;
		}

		int minIndex = index;
		for (int j = minIndex + 1; j < size; j++) {
			if (array[j] < array[minIndex]) {
				minIndex = j;
			}
		}

		if (minIndex != index) {
			// swap
			int temp = array[minIndex];
			array[minIndex] = array[index];
			array[index] = temp;
		}

		recursiveSelectionSort(array, ++index, size);
	}

	public static void recursiveSS(int arr[], int size, int index) {
		if (index < size - 1) {
			recursiveSS(arr, size, ++index);
		} else {
			return;
		}

		int maxIndex = index;
		for (int j = maxIndex - 1; j >= 0; --j) {
			if (arr[j] > arr[maxIndex]) {
				maxIndex = j;
			}
		}

		if (maxIndex != index) {
			// swap
			arr[maxIndex] = arr[maxIndex] + arr[index];
			arr[index] = arr[maxIndex] - arr[index];
			arr[maxIndex] = arr[maxIndex] - arr[index];
		}
	}

}
