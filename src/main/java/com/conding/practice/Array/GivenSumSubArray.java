package com.conding.practice.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GivenSumSubArray {

	public static void main(String[] args) {
		Integer[] arr = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
		List<Integer> list = Arrays.asList(arr);
		findGivenSumSubArray(list, 8);
		findSumSubArray(list, 8);
	}

	public static void findGivenSumSubArray(List<Integer> list, Integer sum) {
		List<Integer> currentList = new ArrayList<>();
		List<Integer> result = new ArrayList<>();

		Integer total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i);
			currentList.add(list.get(i));

			while (total > 8) {
				int num = currentList.remove(0);
				total -= num;
			}

			if (total == 8) {
				if (currentList.size() > result.size()) {
					result.clear();
					result.addAll(currentList);
				}
			}
		}

		result.forEach(a -> {
			System.out.print(a + ",");
		});
	}

	public static void findSumSubArray(List<Integer> list, Integer S) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);

		int sum = 0;
		int len = 0;
		int ending_index = 1;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);

			// if sum is seen for the first time enter sum into map with index.
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

			// update length and ending index of max length sub-array having sum S.
			if (map.containsKey(sum - S) && len < i - map.get(sum - S)) {
				len = i - map.get(sum - S);
				ending_index = i;
			}
		}

		// print the sub-array
		System.out.println("[" + (ending_index - len + 1) + ", " + ending_index + "]");
	}
}
