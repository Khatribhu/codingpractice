package src.java.practice.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletSumZero {

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> results = findTripletWithZeroSum(arr);
		for (List<Integer> result : results) {
			System.out.println(result);
		}
	}

	public static List<List<Integer>> findTripletWithZeroSum(int arr[]) {
		List<List<Integer>> result = new ArrayList<>();
		Set<List<Integer>> resultSet = new HashSet<>();
		int n = arr.length;
		// sorting the array
		Arrays.sort(arr);

		for (int i = 0; i < n - 2; i++) {
			int lo = i + 1;
			int hi = n - 1;
			int sum = 0 - arr[i];
			while (lo < hi) {
				if (sum == arr[lo] + arr[hi]) {
					resultSet.add(Arrays.asList(arr[i], arr[hi], arr[lo]));
					lo++;
					hi--;
				} else if (arr[lo] + arr[hi] < sum) {
					lo++;
				} else {
					hi--;
				}
			}
		}

		for (List<Integer> list : resultSet) {
			result.add(list);
		}
		return result;
	}
}
