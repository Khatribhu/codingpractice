package com.coding.pratice;

import java.util.Random;

public class RamdomNumberFromStreams {

	static int count;
	static int res;

	public static void main(String[] args) {

		int stream[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int n = stream.length;
		for (int i = 0; i < n; i++) {
			System.out.print(randomNumberFromStream(i) + " ");
		}
	}

	/**
	 * Method select random number from string.
	 * 
	 * @param x
	 */
	public static int randomNumberFromStream(int x) {

		count++;

		if (count == 1) {
			res = x;
		} else {
			// Generate a random number from 0 to count - 1.
			Random r = new Random();
			int i = r.nextInt(count);

			// Replace the prev random number with new number with 1/count probablity.
			if (i == count - 1) {
				res = x;
			}

		}
		return res;

	}
}
