package com.coding.practice.Array;

import java.util.ArrayList;
import java.util.List;

public class BuySellStocks {

	public static void main(String[] args) {
		int arr[] = { 7,1,9,3,8,4 };
		System.out.println(findMaxDiff(arr));
		System.out.println(findMaxDiff2(arr));
		System.out.println(findMaxDiff3(arr));
		System.out.println(findMaxDiff4(arr));
		System.out.println(findMaxDiff5(arr));
		int[] price = { 100, 180, 260, 310, 40, 535, 695 };
		// buy and sell stock once
		System.out.println(maxProfil(arr));

		int[] val = { 100, 180, 260, 310, 40, 535, 695 };

		findMaxProfit(arr);
	}

	/**
	 * Method to maximize the profit when only one transaction is allowed
	 */
	public static int maxProfil(int arr[]) {
		return findMaxDiff5(arr);
	}

	/**
	 * Given all values are in ascending order. O(n*n) calculate the diff between.
	 */
	public static int findMaxDiff(int arr[]) {
		int maxDiff = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if ((maxDiff < (arr[j] - arr[i])) && arr[j] > arr[i]) {
					maxDiff = arr[j] - arr[i];
				}
			}
		}
		return maxDiff;
	}

	/**
	 * keeping minElement and maxDiff and traversing. O(n) O(1)
	 */
	public static int findMaxDiff2(int arr[]) {
		int minEle = arr[0];
		int maxDiff = arr[1] - arr[0];
		if(maxDiff < 0) {
			maxDiff = 0;
		}

		for (int i = 1; i < arr.length; i++) {
			if ((arr[i] - minEle) > maxDiff) {
				maxDiff = arr[i] - minEle;
			}
			if (arr[i] < minEle) {
				minEle = arr[i];
			}
		}
		return maxDiff;
	}

	/**
	 * Keeping the max element at the end, and finding the maxDiff by comparing
	 * through array.
	 */
	public static int findMaxDiff3(int arr[]) {
		int maxEle = arr[arr.length - 1];
		int maxDiff = 0;

		for (int i = arr.length - 2; i >= 0; i--) {
			// first check number if this is greater than current.
			if (arr[i] > maxEle) {
				maxEle = arr[i];
			} else {
				if ((maxEle - arr[i]) > maxDiff) {
					maxDiff = maxEle - arr[i];
				}
			}
		}

		return maxDiff;
	}

	/**
	 * Finding the diff between adjacent elements O(n) Space: O(n)
	 */
	public static int findMaxDiff4(int arr[]) {

		int n = arr.length;
		// Create a diff array of size n-1. The array will hold
		// the difference of adjacent elements
		int diff[] = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			diff[i] = arr[i + 1] - arr[i];
		}

	//	printArray(arr);
	//	System.out.println();
	//	printArray(diff);
		// Now find the maximum sum subarray in diff array
		int max_diff = diff[0];
		for (int i = 1; i < n - 1; i++) {
			if (diff[i - 1] > 0)
				diff[i] += diff[i - 1];
			if (diff[i] > max_diff) {
				max_diff = diff[i];
			}
		}
		return max_diff;
	}

	/**
	 * Taking diff between adjacent elements O(n) O(1)
	 */
	public static int findMaxDiff5(int arr[]) {
		int n = arr.length;
		int diff = arr[1] - arr[0];
		int curr_sum = diff;
		int max_sum = curr_sum;

		for (int i = 1; i < n - 1; i++) {
			diff = arr[i + 1] - arr[i];

			if (curr_sum > 0) {
				curr_sum += diff;
			} else {
				curr_sum = diff;
			}

			if (curr_sum > max_sum) {
				max_sum = curr_sum;
			}
		}
		return max_sum;
	}

	public static void printArray(int[] arr) {
		System.out.println("printing array");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	
	public static void findMaxProfitBK(int[] price) {
		int n = price.length;
		if(n == 1) {
			return;
		}
		
		int i = 0;
		while(i < n) {
			
			//find local minima
			for(int i = 0; i < )
		}
	}
	/**
	 * When buying and selling can be done multiple times.
	 */
	public static void findMaxProfit(int[] price) {
		int n = price.length;

		// if only one element is present.
		if (n == 1) {
			return;
		}

		int count = 0;
		int profit = 0;
		List<Interval> sol = new ArrayList<>();

		int i = 0;
		while (i < n - 1) {

			// find local minima
			while (i < (n - 1) && (price[i + 1] <= price[i])) {
				i++;
			}

			// if we reach end
			if (i == n - 1) {
				break;
			}

			Interval e = new Interval();
			e.buy = i++;
			// store the index of minima.

			// find local maxima. note limit is (n-1)
			while ((i < n) && (price[i] >= price[i - 1])) {
				i++;
			}

			// store the max index
			e.sell = i - 1;
			e.profit = price[e.sell] - price[e.buy];
			sol.add(e);

			count++;
		}

		if (count == 0) {
			System.out.println("there is no solution exists for any day purchase");
		} else {
			for (Interval val : sol) {
				profit += val.profit;
				System.out.println("Buy day: " + val.buy + " Sell day: " + val.sell);
			}
			System.out.println("Total profit: " + profit);
		}
		if (count > 0) {

		}
	}

	static class Interval {
		int buy, sell, profit;
	}
}