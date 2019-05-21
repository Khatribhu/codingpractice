/**
 * 
 */
package com.coding.practice.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bkhatri3 Given an array of integers, find maximum product of two
 *         integers in an array.
 */
public class MaxProductOfTwoIntegers {

	public static void main(String[] args) {
		Integer[] arr = { -10, -1, 4, 5, 6, -2 };
		Map<Integer, Integer> map = findMaxProductPairs(arr);
		map.forEach((a, b) -> {
			System.out.println("key: " + a + " Value :" + b);
		});

	}

	// O(n)
	public static Map<Integer, Integer> findMaxProductPairs(Integer[] arr) {
		int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
		Long max1 = 0l, max2 = 0l;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				secondMax = max;
				max = arr[i];
			}

			if (arr[i] < 0 && arr[i] < min) {
				min = arr[i];
			}

			if (arr[i] < 0 && arr[i] > min && arr[i] < secondMin) {
				secondMin = arr[i];
			}

		}

		if (secondMin != Integer.MAX_VALUE && min != Integer.MAX_VALUE) {
			max1 = (long) (min * secondMin);
		}

		if (secondMax != Integer.MAX_VALUE && max != Integer.MAX_VALUE) {
			max2 = (long) (max * secondMax);
		}

		int cmp = max1.compareTo(max2);
		switch (cmp) {
		case 0:
			map.put(min, secondMin);
			map.put(max, secondMax);
			return map;
		case 1:
			map.put(min, secondMin);
			return map;
		default:
			map.put(max, secondMax);
			return map;

		}

	}
}
