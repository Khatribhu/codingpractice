package com.coding.practice.sorting;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MaxPalindromeSubString {

	public static void main(String[] args) {
		// System.out.println(palindrome("shalalaa"));
		System.out.println(findLongestPalimdrome("185938385670"));
		// printSubStrings("khatri");
	}

	public static String findLongestPalimdrome(String str) {
		int maxLength = 0;
		String result = "";
		int n = str.length();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				String subString = str.substring(i, j);
				if (palindrome(subString)) {
					if (subString.length() > maxLength) {
						maxLength = subString.length();
						result = subString;
					}
				}
			}
		}
		return result;
	}

	/**
	 * time complexity O(n*n*n)
	 * 
	 * @param str
	 */
	public static void printSubStrings(String str) {
		int count = 0;
		int n = str.length();
		// pick length of substring
		for (int len = 1; len <= n; len++) {
			// pick starting point
			for (int i = 0; i <= n - len; i++) {

				/* print characters from current starting point to current ending point */
				int j = i + len - 1;
				for (int k = i; k <= j; k++) {
					System.out.print(str.charAt(k));
				}
				count++;
				System.out.println();
			}
		}
		System.out.println(count);
	}

	public static void printSubStringUsingSubString(String str) {
		int n = str.length();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				System.out.println(str.substring(i, j));
			}
		}

	}

	/**
	 * Method to check if given input string's permutation is palindrome.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean palindrome(String input) {
		char[] charArray = input.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < charArray.length; i++) {
			if (map.containsKey(charArray[i])) {
				int count = map.get(charArray[i]);
				++count;
				map.put(charArray[i], count);
			} else {
				map.put(charArray[i], 1);
			}
		}

		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		boolean oddFound = false;
		for (Entry<Character, Integer> entry : entrySet) {
			// odd already found
			if (entry.getValue() % 2 != 0) {
				if (oddFound) {
					return false;
				} else {
					oddFound = true;
				}
			}
		}
		return true;

	}
}
