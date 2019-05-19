package com.conding.practice.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistinctValueSubArray {

	public static void main(String[] args) {
		Integer[] arr = { 2, 0, 2, 8, 4, 3, 1, 0 };
		List<Integer> list = Arrays.asList(arr);
		printLargestDistinctSubArray(list);
	}

	public static void printLargestDistinctSubArray(List<Integer> list) {
		Set<Integer> result = new HashSet<>();
		Map<Integer, Integer> current = new HashMap<>();
		Integer max = 0;
		Integer end = 0;

		for (int i = 0; i < list.size();) {
			if (current.containsKey(list.get(i))) {
				Integer start = current.get(list.get(i));
				end = i;
				if ((end - start) > max) {
					max = end - start;
					result.clear();
					result.addAll(current.keySet());
					current.clear();
					i = start + 1;
					continue;
				}
			} else {
				current.put(list.get(i), i);
			}
			i++;
		}

		result.forEach(a -> {
			System.out.print(a + " , ");
		});

	}
}
