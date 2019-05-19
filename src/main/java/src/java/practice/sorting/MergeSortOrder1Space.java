package src.java.practice.sorting;

import java.util.Arrays;

public class MergeSortOrder1Space {
	/**
	 * 
	 * Merge sort with O(1)space
	 * 
	 * @param original
	 * @param n
	 */
	public static void mergeSortOrder1Space(int[] original, int n) {
		int maxele = Arrays.stream(original).max().getAsInt() + 1;
		mergeSortO1Space(original, 0, n - 1, maxele);
	}

	public static void mergeSortO1Space(int[] original, int beg, int end, int maxele) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			mergeSortO1Space(original, beg, mid, maxele);
			mergeSortO1Space(original, mid + 1, end, maxele);
			merge01Space(original, beg, mid, end, maxele);
		}
	}

	public static void merge01Space(int[] original, int beg, int mid, int end, int maxEle) {
		int i = beg;
		int j = mid + 1;
		int k = beg;
		while (i <= mid && j <= end) {

			if (original[i] % maxEle <= original[j] % maxEle) {
				original[k] += (original[i] % maxEle) * maxEle;
				k++;
				i++;
			} else {
				original[k] += (original[j] % maxEle) * maxEle;
				k++;
				j++;
			}

			while (i <= mid) {
				original[k] += (original[i] % maxEle) * maxEle;
				k++;
				i++;
			}
			while (j <= end) {
				original[k] += (original[j] % maxEle) * maxEle;
				k++;
				j++;
			}

			// Obtaining actual values
			for (i = beg; i <= end; i++) {
				original[i] /= maxEle;
			}
		}
	}
}