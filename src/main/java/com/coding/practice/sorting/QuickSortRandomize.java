package com.coding.practice.sorting;

public class QuickSortRandomize {

	public static void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		sort(arr, 0, arr.length - 1);
		printArray(arr);
	}

	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition_r(arr, low, high);
			sort(arr, low, pi);
			sort(arr, pi + 1, high);
		}
	}

	public static int partition_r(int[] arr, int low, int high) {

		int randomNum = (int) (low + Math.random() % (high - low));
		swap(arr, low, randomNum);
		return partition(arr, low, high);
	}

	// using hoare's partition
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[low], i = low, j = high;
		while (true) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i >= j) {
				return j;
			}
			swap(arr, i, j);
		}
	}

	public static void swap(int[] arr, int to, int from) {
		if (to != from && arr[to] != arr[from]) {
			arr[to] = arr[to] + arr[from];
			arr[from] = arr[to] - arr[from];
			arr[to] = arr[to] - arr[from];
		}
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
