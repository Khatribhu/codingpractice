package com.conding.practice.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;

public class FindPairWithGivenSum {

	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(8);
		findPairWithGivenSum(list, 4);

	}

	// Time : O(n), Space O(n)
	public static Map<Integer, Integer> findPairWithGivenSum(List<Integer> list, int sum) {
		Set<Integer> hashSet = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();

		list.forEach(a -> {
			if (hashSet.contains(sum - a)) {
				map.put(a, sum - a);
			} else {
				hashSet.add(a);
			}
		});

		Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
		entrySet.forEach(a -> {
			System.out.println("key: " + a.getKey() + " value: " + a.getValue());
		});

		return map;
	}
	
	
}
