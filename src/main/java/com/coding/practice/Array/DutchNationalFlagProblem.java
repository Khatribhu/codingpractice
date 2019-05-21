package com.coding.practice.Array;

import java.util.List;

/**
 * An Array Containing 0,1,2 sort the array in linear time and constant space.
 * 
 * @author bkhatri3
 *
 */
public class DutchNationalFlagProblem {
	public static void main(String[] args) {
		Integer arr[] = { 9, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4 };
		sort(arr, 0, arr.length - 1);
		printArray(arr);
	}

	// we can use three way partitioning, 0, 1, 2, here 1 as pivot.
	public static void sort(Integer[] arr, int lo, int hi) {

		if (lo < hi) {
			int pivot = arr[lo];
			int lt = lo, gt = hi;
			int i = lo + 1;
			while (i <= gt) {
				int cmp = arr[i].compareTo(pivot);
				if (cmp < 0) {
					swap(arr, lt++, i);
				} else if (cmp > 0) {
					swap(arr, gt--, i);
				} else {
					i++;
				}
			}

			sort(arr, lo, lt + 1);
			sort(arr, gt - 1, hi);
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
