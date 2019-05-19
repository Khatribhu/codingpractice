package com.coding.practice.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistanceArray {

	// Complete the minimumDistances function below.
	static int minimumDistances(int[] array) {
		Map<Integer, int[]> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				int[] values = map.get(array[i]);
				if ((i - values[0]) < values[1]) {
					values[1] = (Math.subtractExact(i, values[0]));
					values[0] = i;
					list.add(values[1]);
				}
			} else {
				int[] values = new int[2];
				values[0] = i;
				values[1] = Integer.MAX_VALUE;
				map.put(array[i], values);
			}
		}

		Collections.sort(list);
		if (list.size() > 0) {
			list.get(0);
		} else {
			return 0;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] array = { 7, 1, 3, 4, 1, 7 };
		System.out.println(minimumDistances(array));
	}
}
