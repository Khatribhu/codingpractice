package src.java.practice.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Merge sort is divide and conquer.
 * 
 * @author bkhatri3
 *
 */
public class MergeSort {

	public static void main(String[] args) throws InterruptedException {
		int[] array = { 12, 4, 66, 3, 1, 0 };
		int[] arrayNew = { 42, -2, -45, 78, 30, -42, 10, 19, 73, 93 };
		MergeSortThreeWay obj = new MergeSortThreeWay();
		// sort(array, 0, array.length - 1);
		// mergeSortOrder1Space(array, 6);
		// obj.mergeSort3Way(arrayNew);
		// printArray(array);

		Random rand = new Random();
		int[] original = new int[10000000];
		for (int i = 0; i < original.length; i++) {
			original[i] = rand.nextInt(1000);
		}
		long startTime = System.currentTimeMillis();
		sort(original, 0, original.length - 1);

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("bk MergeSort takes: " + (float) elapsedTime / 1000 + " seconds");
		long startTime2 = System.currentTimeMillis();
		Arrays.sort(original);
		
		long endTime2 = System.currentTimeMillis();
		long elapsedTime2 = endTime2 - startTime2;
		System.out.println("2-thread MergeSort takes: " + (float) elapsedTime2 / 1000 + " seconds");
		//MergeSortThreaded.start();
//		MergeLinkedList mergeLinkedList = new MergeLinkedList();
//		mergeLinkedList.createLinkedListAndSort();

		int sortedArr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		worstCaseMergeSort.generateWorstCase(sortedArr, 0, sortedArr.length - 1);
		printArray(sortedArr);
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void merge(int[] array, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	public static void sort(int[] array, int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(array, l, m);
			sort(array, m + 1, r);

			// Merge the sorted halves
			merge(array, l, m, r);
		}
	}

}

class InPlaceMergeSort {

	/**
	 * Time complexity of approach is O(n*n logn) because merge is O(n*n) time
	 * complexity of startdard merge sort is O(nlogn)
	 * 
	 * @param arr
	 * @param l
	 * @param r
	 */
	public static void mergeSort(Integer[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);

			merge(arr, l, mid, r);
		}
	}

	public static void merge(Integer[] arr, int start, int mid, int right) {
		int start2 = mid + 1;

		// if direct merge is already sorted.
		if (arr[mid] <= arr[start2]) {
			return;
		}

		while (start <= mid && start2 <= right) {

			// if element 1 is in right place
			if (arr[start] <= arr[start2]) {
				start++;
			} else {
				int val = arr[start2];
				int index = start2;

				// shifting all the elements between element 1 and element 2, right by 1.
				while (index != start) {
					arr[index] = arr[index - 1];
					index--;
				}
				arr[start] = val;

				// update all pointers
				start++;
				mid++;
				start2++;

			}
		}
	}
}

class worstCaseMergeSort {

	/**
	 * 
	 * Function to store alternate elements in left and right subarray.
	 */
	public static void split(int[] arr, int[] left, int[] right, int l, int m, int r) {
		for (int i = 0; i < m - l; i++) {
			left[i] = arr[i * 2];
		}

		for (int i = 0; i < r - m; i++) {
			right[i] = arr[i * 2 + 1];
		}
	}

	/**
	 * function to join left and right subarray
	 */
	public static void join(int[] arr, int[] left, int[] right, int l, int m, int r) {
		int i;
		for (i = 0; i < m - l; i++) {
			arr[i] = left[i];
		}
		for (int j = 0; j < r - m; j++) {
			arr[i + j] = right[j];
		}
	}

	public static void generateWorstCase(int arr[], int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;

			// create two aux arrays
			int left[] = new int[m - l + 1];
			int right[] = new int[r - m];

			// store the alternate elements in left and right subarray.
			split(arr, left, right, l, m, r);

			// recursve first and second half
			generateWorstCase(left, l, m);
			generateWorstCase(right, m + 1, r);

			// join left and right subarray
			join(arr, left, right, l, m, r);
		}
	}
}