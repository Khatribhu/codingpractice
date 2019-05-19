package com.coding.practice.sorting;

public class MergeSortThreeWay {
	public static void mergeSort3Way(Integer[] arr) {
		if (arr == null) {
			return;
		}

		Integer[] duplicateArray = new Integer[arr.length];

		// copy elements from original array to duplicate.
		for (int i = 0; i < arr.length; i++) {
			duplicateArray[i] = arr[i];
		}

		// sort function
		threeWayMergeSort(duplicateArray, 0, arr.length, arr);

	}

	public static void threeWayMergeSort(Integer[] arr, int low, int high, Integer[] destArray) {
		// if array size is 1, do nothing.
		if (high - low < 2) {
			return;
		}

		// split array into three
		int mid1 = ((high - low) / 3) + low;
		int mid2 = 2 * ((high - low) / 3) + low + 1;

		// sort three array recursively
		threeWayMergeSort(destArray, low, mid1, arr);
		threeWayMergeSort(destArray, mid1, mid2, arr);
		threeWayMergeSort(destArray, mid2, high, arr);

		mergeThreeWaySort(destArray, low, mid1, mid2, high, arr);

	}

	/**
	 * merge the sorted ranges, low - mid1, mid1 - mid2, mid2 - high.
	 */
	public static void mergeThreeWaySort(Integer[] destArr, int low, int mid1, int mid2, int high, Integer[] arr) {
		int i = low, j = mid1, k = mid2, l = low;

		// choose smaller of smallest in three ranges
		while ((i < mid1) && (j < mid2) && (k < high)) {
			if (arr[i].compareTo(arr[j]) < 0) {
				if (arr[i].compareTo(arr[k]) < 0) {
					destArr[l++] = arr[i++];
				} else {
					destArr[l++] = arr[k++];
				}
			} else {
				if (arr[j].compareTo(arr[k]) < 0) {
					destArr[l++] = arr[j++];
				} else {
					destArr[l++] = arr[k++];
				}
			}
		}

		// case where first and second have remaining values
		while (i < mid1 && j < mid2) {
			if (arr[i].compareTo(arr[j]) < 0) {
				destArr[l++] = arr[i++];
			} else {
				destArr[l++] = arr[j++];
			}
		}

		// case where second and third have remaining values
		while (k < high && j < mid2) {
			if (arr[j].compareTo(arr[k]) < 0) {
				destArr[l++] = arr[j++];
			} else {
				destArr[l++] = arr[k++];
			}
		}

		// case where first and third have remaining values
		while (i < mid1 && k < high) {
			if (arr[i].compareTo(arr[k]) < 0) {
				destArr[l++] = arr[i++];
			} else {
				destArr[l++] = arr[k++];
			}
		}

		// where first has remaining values
		while (i < mid1) {
			destArr[l++] = arr[i++];
		}

		// where second has remaining values
		while (j < mid2) {
			destArr[l++] = arr[j++];
		}

		// where third has remaining values
		while (k < high) {
			destArr[l++] = arr[k++];
		}

	}
}
