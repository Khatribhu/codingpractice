package com.coding.practice.general;

import java.util.Arrays;

/**
 * Method to find smallest number which is not created summing elements of given
 * number array.
 * 
 * @param array
 * @return
 */
public class SmallestNonConstructibleValue {

	public static void main(String[] args) {
		int[] array = { 1, 1, 1, 1, 1, 5, 10, 25 };
		int[] arr = { 1, 2, 2, 4, 12, 15 };
		System.out.println(smallestNonConstructibleValue(arr));
	}

	public static int sum(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	/**
	 * Sort the array with numbers, 
	 * Suppose a collection of numbers can produce every value upto and including V, but not V+1. 
	 * Now consider the adding new element u to the collection. 
	 * if u <= V+1, we can still produce every value upto and including V+u and we cannot produce V+u+1. 
	 * On the other hand, 
	 * if u > V + 1, then even by adding u to the collection we cannot reproduce V+1.
	 * 
	 * Time complexity of this solution is O(log n) to sort and O(n) to iterate.
	 * overall : O(nlog n)
	 * @param array
	 * @return
	 */
	public static int smallestNonConstructibleValue(int[] array) {
		Arrays.sort(array);
		int maxReconstrutibleValue = 0;
		for (int arr : array) {
			if (arr > maxReconstrutibleValue + 1) {
				break;
			}
			maxReconstrutibleValue += arr;
		}
		return maxReconstrutibleValue + 1;
	}
	
	
}