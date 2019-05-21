/**
 * 
 */
package com.coding.practice.Array;

import java.util.Random;

/**
 * @author bkhatri3
 * 
 * @see Fisher yates shuffle is used to generate random permutations. it takes
 *      time proportional to the number of items being shuffled and shuffles
 *      them in place.
 *
 */
public class UnbiasedPermutationShuffle {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 34, 1, 3, 2, 3 };
		shuffleArray(arr);
	}

	public static void shuffleArray(int[] arr) {
		Random rand = new Random();
		for (int i = 1; i < arr.length; i++) {
			int random = rand.nextInt(i);
			swap(arr, i, random);
			print(arr);
			System.out.println();
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

}
