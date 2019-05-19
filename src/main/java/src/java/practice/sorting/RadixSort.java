package src.java.practice.sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
		radixSort(arr, arr.length);
		printArray(arr);
	}

	public static void sort(int[] arr) {

	}

	public static int getMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	/**
	 * A function to do counting sort of arr[] according to digit represented by
	 * exp.
	 */
	public static void countSort(int arr[], int n, int exp) {
		int[] output = new int[n];
		int i;
		int[] count = new int[10];
		Arrays.fill(count, 0);

		// store the occurance in count
		for (i = 0; i < arr.length; i++) {
			count[(arr[i] / exp) % 10]++;
		}

		// change the count[i] so that it contains actual position of digit in output[]
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		// build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// count the output array to arr[], so that arr[] now contains sorted numbers
		// according to current digit.
		for (i = 0; i < n; i++) {
			arr[i] = output[i];
		}
	}

	public static void radixSort(int[] arr, int n) {
		// find the max number to know number of digits
		int max = getMax(arr);

		// do a counting sort for every digit. Note instead of passing a digit number
		// exp is passed.
		// exp is 10^i where i is the current digit.
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countSort(arr, n, exp);
		}
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}