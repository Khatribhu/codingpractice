package com.coding.practice.sorting;

public class QuickSortThreeWay {

	public static void main(String[] args) {
		Integer arr[] = { 4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4 };
		sort(arr, 0, arr.length - 1);
		printArray(arr);
	}

	public static void sort(Integer[] arr, Integer lo, Integer hi) {
		if (lo < hi) {
			Integer lt = lo, gt = hi;
			Integer pivot = arr[lo];
			Integer i = lo + 1;
			while (i <= gt) {
				Integer cmp = arr[i].compareTo(pivot);
				if (cmp < 0)
					swap(arr, lt++, i++);
				else if (cmp > 0)
					swap(arr, i, gt--);
				else
					i++;
			}

			// a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
			sort(arr, lo, lt - 1);
			sort(arr, gt + 1, hi);
		}
	}

	public static void swap(Integer[] arr, Integer to, Integer from) {
		if (to != from && arr[to] != arr[from]) {
			arr[to] = arr[to] + arr[from];
			arr[from] = arr[to] - arr[from];
			arr[to] = arr[to] - arr[from];
		}
	}

	public static void printArray(Integer arr[]) {
		for (Integer i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
