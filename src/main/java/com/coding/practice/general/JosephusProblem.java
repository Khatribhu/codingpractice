package com.coding.practice.general;

/**
 * The counting out begins at some point in the circle and proceeds around the
 * circle in a fixed direction in each step, certain number of people are
 * skipped and the next person is executed. 
 * The elimination proceeds around the circle. 
 * Given n people and number k which indicates that k-1 persons are skipped and kth person is killed.
 * 
 * @author bkhatri3
 *
 */
public class JosephusProblem {

	public static void main(String[] args) {
		String str = Integer.toBinaryString(16);

//		System.out.println(josephusUsingBitManipulation(str));
//		System.out.println(josephus(13));
		System.out.println(josephusWithK(14, 3));
	}

	public static boolean isPowerOfTwo(int input) {
		while (input % 2 == 0) {
			input /= 2;
		}
		if (input == 1) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Here we are calculating N = a power of 2 + something
	 * then asnwer would be 2 * something + 1. 
	 */
	public static int josephus(int input) {
		int val = 2;

		if (isPowerOfTwo(input)) {
			return 1;
		}
		while (val * 2 < input) {
			val *= 2;
		}

		return 2 * (input - val) + 1;
	}

	public static int josephusUsingBitManipulation(String input) {
		char[] charArray = input.toCharArray();
		char val = charArray[0];

		for (int i = charArray.length - 1; i > 0; i--) {
			charArray[i - 1] = charArray[i];
		}

		charArray[charArray.length - 1] = val;

		StringBuilder stBuild = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			stBuild.append(charArray[i]);
		}
		return Integer.parseInt(stBuild.toString());

	}

	public static int josephusWithK(int n, int k) {
		if (n == 1) {
			return 1;
		} else {
			// the position return by josephus(n-1, k) is adjusted because the recursive
			// call josephus(n-1, k) considers the original position k%n +1 as position 1
			return (josephusWithK(n - 1, k) + k - 1) % n + 1;
		}
	}
}
