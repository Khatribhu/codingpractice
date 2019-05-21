package com.coding.practice.Array;

/**
 * Given a binary array find, the index of 0 to be replaced with 1 to get max
 * length subsequence of 1.
 * 
 * @author bkhatri3
 *
 */
public class FindIndexOfZeroToBeReplacedToFindMaxOnes {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
		findIndexOfZero2(arr);
	}

	// Find index of 0 to replaced with 1 to get maximum sequence
	// of continuous 1's
	public static int findIndexofZero(int[] A) {
		int max_count = 0; // stores maximum number of 1's (including 0)
		int max_index = -1; // stores index of 0 to be replaced

		int prev_zero_index = -1; // stores index of previous zero
		int count = 0; // store current count of zeros

		// consider each index i of the array
		for (int i = 0; i < A.length; i++) {
			// if current element is 1
			if (A[i] == 1) {
				count++;
			} else
			// if current element is 0
			{
				// reset count to 1 + no. of ones to the left of current 0
				count = i - prev_zero_index;

				// update prev_zero_index to current index
				prev_zero_index = i;
			}

			// update maximum count & index of 0 to be replaced if required
			if (count > max_count) {
				max_count = count;
				max_index = prev_zero_index;
			}
		}

		// return index of 0 to be replaced or -1 if array contains all 1's
		return max_index;
	}

	public static void findIndexOfZero2(int[] arr) {
		int lastIndexOfZero = 0;
		int count = 0, maxCount = -1;
		int resultIndex = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count++;
			} else {
				count = i - lastIndexOfZero;
				lastIndexOfZero = i;
			}

			if (count > maxCount) {
				maxCount = count;
				resultIndex = lastIndexOfZero;
			}

		}

		System.out.println(resultIndex);

	}
}
