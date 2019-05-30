package com.coding.practice.Array;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		Integer arr[] = { 1, 34, 3, 98, 9, 76, 45, 4, 12, 121 };
		List<Integer> list = Arrays.asList(arr);
		System.out.println(largestNumber(list));
		printLargest(list);

	}

	public static String largestNumber(List<Integer> list) {

		int n = Collections.max(list).toString().length();

		List<ExtendedNum> en = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			en.add(new ExtendedNum(list.get(i), n));
		}

		// sort based on modified values.
		Collections.sort(en, (p1, p2) -> (int) (p2.modifiedValue - p1.modifiedValue));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < en.size(); i++) {
			sb.append(new StringBuilder(Long.toString(en.get(i).originalValue)));
		}

		// to remove zero at the head.
		BigInteger bi = new BigInteger(sb.toString());
		return bi.toString();
	}

	public static void printLargest(List<Integer> str) {

		Collections.sort(str, (p1, p2) -> {
			String XY = p1.toString() + p2.toString();
			String YX = p2.toString() + p1.toString();
			return YX.compareTo(XY);
		});

		str.forEach(System.out::print);
	}
}

class ExtendedNum {
	int originalValue;
	long modifiedValue;

	public ExtendedNum(int originalValue, int n) {
		this.originalValue = originalValue;
		String s = Integer.toString(originalValue);
		StringBuilder sb = new StringBuilder(s);
		StringBuilder ans = new StringBuilder();

		while (ans.length() <= n + 1) {
			ans.append(sb);
		}

		s = ans.toString().substring(0, n + 1);
		modifiedValue = Long.parseLong(s);
	}

	public String toString() {
		return "[" + modifiedValue + ", " + originalValue + "]";
	}
}
