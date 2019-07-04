package com.coding.practice.Array;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FindUniqueString {

	public static void main(String[] args) {
		String str = "ACB";
		System.out.println(isUnique(str));
		System.out.println("hello how are you".replaceAll(" ", "%20"));
		stringCompression("aabccccc");
	}

	private static boolean isUnique(String str) {
		int n = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			n ^= str.charAt(0);
		}
		if (n == 0) {
			return false;
		}
		return true;
	}

	private static void stringCompression(String input) {
		StringBuilder stBuild = new StringBuilder();
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				int freq = map.get(input.charAt(i));
				map.put(input.charAt(i), ++freq);
			} else {
				map.put(input.charAt(i), 1);
			}
		}

		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		for (Map.Entry<Character, Integer> entry : set) {
			stBuild.append(entry.getKey());
			stBuild.append(entry.getValue());
		}

		System.out.println(stBuild);
	}
}
