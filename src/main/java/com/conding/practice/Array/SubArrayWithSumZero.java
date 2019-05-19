package com.conding.practice.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayWithSumZero {

	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
		Integer arr[] = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
		list = Arrays.asList(arr);
		subArrayWithSumZero(list);
	}

	public static Map<Integer, List<Pair>> subArrayWithSumZero(List<Integer> list) {

		Map<Integer, List<Pair>> resultMap = new HashMap<>();
		int sum = 0;
		List<Pair> pairList = null;

		for (int i = 0; i < list.size(); i++) {

			sum = list.get(i);
			pairList = new ArrayList<>();

			// if element is 0
			if (sum == 0) {
				pairList.add(new Pair(i, i));
				resultMap.put(i, pairList);
			}

			for (int j = i + 1; j < list.size(); j++) {
				sum += list.get(j);

				if (sum == 0) {
					pairList.add(new Pair(i, j));
					resultMap.put(i, pairList);
				}
			}
		}
		
		resultMap.entrySet().forEach(a -> {
			a.getValue().forEach(b -> {
				System.out.print("key : " + b.first + " value :" + b.second+"\n");
			});
		});

		return resultMap;

	}

}

class Pair {
	Integer first;
	Integer second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
