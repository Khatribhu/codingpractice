package com.coding.pratice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class bitWiseOperations {

	public static int add(int x, int y) {
		int carry;
		while (y != 0) {
			carry = x & y;
			x = x ^ y;
			y = carry << 1;
			System.out.println("carry :" + carry);
			System.out.println(x + " " + y);
		}
		return x;
	}

	public static int findIndex(int[] arr, int num) {

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}

		return -1;

	}

	public static int count_one(int n) {

		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	public static int count_one2(int x) {
		short numBits = 0;
		while (x != 0) {
			numBits += (x & 1);
			x >>>= 1;
		}
		return numBits;
	}

	/**
	 * '^' stands for XOR it gives 1 if bits are different gives 0 if bits are same
	 * 
	 * @param x
	 * @return
	 */
	public static int calculateParity(long x) {
		short result = 0;
		while (x != 0) {
			result ^= 1;
			x &= (x - 1);
		}
		return result;
	}

	public static short parity(long x) {
		x ^= x >>> 32;
		x ^= x >>> 16;
		x ^= x >>> 8;
		x ^= x >>> 4;
		x ^= x >>> 2;
		x ^= x >>> 1;

		return (short) (x & 0x1);
	}

	/**
	 * Time complexity is O(1)
	 * 
	 * @param x
	 * @param i
	 * @param j
	 * @return
	 */
	public static long swapBits(long x, int i, int j) {

		// both of the keys are not same.
		if ((x & (1 << (i))) != (x & (1 << (j)))) {
			x ^= (1 << (i));
			x ^= (1 << (j));
		}
		return x;
	}

	public static long reverseBits(int n) {
		int rev = 0;

		// traversing bits of n from right.
		while (n > 0) {

			// bitwise left shift 'rev' by 1.
			rev <<= 1;

			// if the current bit is '1'.
			if ((int) (n & 1) == 1) {
				rev ^= 1;
			}

			// bitwise right shirt n by 1.
			n >>= 1;
		}
		return rev;
	}

	public static long closestSameWeight(long n) {
		int size = (int) (Math.log(n) / Math.log(2) + 1);
		for (int i = 1; i <= size - 1; i++) {
			long result = swapBits(n, i, i + 1);
			if (result != n) {
				return result;
			}
		}
		return 0L;

	}

	public static void main(String[] args) {

		System.out.println(closestSameWeight(8));
		System.out.println(swapBits(2, 1, 0));
		System.out.println(calculateParity(3));
		System.out.println("counting number of 1's");
		System.out.println(count_one2(4));
		System.out.println(count_one(4));
		System.out.println(add(7, 7));
		printCombination(4);
		System.out.println(countNumberOfOnes(3));
		System.out.println(isNthBitSet(20, 3));

		Map<String, String> map = new HashMap<>();
		map.put("String", "khatri");
		map.put("String", null);
		map.put(null, null);
		System.out.println(map.toString());

		Set<String> set = new HashSet<>();
		set.add(null);
		set.add("khatri");
		set.add(null);
		System.out.println(set.toString());

		List<String> list = new ArrayList<>();
		list.add("khatri");
		list.add(null);
		list.add(null);
		System.out.println(list.toString());

		Map<String, String> treeMap = new TreeMap<>();
		treeMap.put("abc", null);
		treeMap.put("abc", null);
		System.out.println(treeMap.toString());

		Set<String> treeSet = new TreeSet<>();
		treeSet.add("khatri");
		treeSet.add(null);
		treeSet.add(null);
		System.out.println(treeSet.toString());

	}

	public static boolean isNthBitSet(int number, int n) {
		if ((number & 1 << n) != 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void printCombination(int setNumber) {
		for (int i = 0; i < (1 << setNumber); i++) {
			for (int j = 0; j < setNumber; j++) {
				System.out.print(isNthBitSet(i, j) ? "1" : "0");
			}
			System.out.println();
		}
	}

	public static int countNumberOfOnes(int val) {
		int count = 0;
		while (val != 0) {
			val = val & val - 1;
			count++;
		}

		return count;
	}
	
	/**
	 * Do left rotation for n by d bits
	 * @param n
	 * @param d
	 * @return
	 */
	public static int shiftingNumbersToTheRight(int n, int d) {
		String str = Integer.toBinaryString(n);
		return n << d | n >> (str.length() - d);
	}

}