package src.java.practice.DP;

import java.util.HashMap;
import java.util.Map;

public class NumberOfArrayWithSumK {

	public static void main(String[] args) {

		int arr[] = { 10, 2, -2, -20, 10 };
		int sum = 0;
		int n = arr.length;
		System.out.println(numberOfSubArrayWithSumK(arr, n, sum));
	}

	public static int numberOfSubArrayWithSumK(int arr[], int n, int sum) {

		// map to store subarray indexes with sum k
		Map<Integer, Integer> prevSum = new HashMap<>();

		int res = 0;
		// sum of elements so far.
		int currSum = 0;
		for (int i = 0; i < n; i++) {
			// add the current element
			currSum += arr[i];

			// if curr sum equals to sum then increment result.
			if (currSum == sum) {
				res++;
			}

			// currsum exceeds given sum by currsum
			// - sum. Find number of subarrays having
			// this sum and exclude those subarrays
			// from currsum by increasing count by
			// same amount.
			if (prevSum.containsKey(currSum - sum))
				res += prevSum.get(currSum - sum);

			// add curr sum value to the count of diff values of sum
			Integer count = prevSum.get(currSum);
			if (count == null) {
				prevSum.put(currSum, 1);
			} else {
				prevSum.put(currSum, count + 1);
			}

		}
		return res;
	}
}
