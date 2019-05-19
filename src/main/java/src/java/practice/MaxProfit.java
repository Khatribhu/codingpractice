package src.java.practice;

public class MaxProfit {

	public static void main(String[] args) {
		int[] arr = { 3, 8, 6, 5, 16, 2 };
		System.out.println(findMaxProfit(arr));
		System.out.println(findMaxProfit2(arr));
		System.out.println(findMaxProfit3(arr));
		System.out.println(maxDiff(arr, arr.length));
	}

	/**
	 * Brute force method.
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMaxProfit(int[] arr) {
		int maxDiff = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i] && (arr[j] - arr[i]) > maxDiff) {
					maxDiff = arr[j] - arr[i];
				}
			}
		}
		return maxDiff;
	}

	/**
	 * Time : O(n), Space O(1) using min element.
	 * 
	 * @param arr
	 * @return
	 */
	public static int findMaxProfit2(int[] arr) {
		int maxDiff = arr[1] - arr[0];
		int minElement = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - minElement > maxDiff) {
				maxDiff = arr[i] - minElement;
			}
			if (arr[i] < minElement) {
				minElement = arr[i];
			}
		}
		return maxDiff;
	}

	public static int findMaxProfit3(int[] arr) {
		int maxDiff = arr[arr.length - 1] - arr[arr.length - 2];
		int maxElement = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (maxElement - arr[i] > maxDiff) {
				maxDiff = maxElement - arr[i];
			}

			if (arr[i] > maxElement) {
				maxElement = arr[i];
			}
		}

		return maxDiff;
	}

	public static int maxDiff(int arr[], int n) {
		// Create a diff array of size n-1. The array will hold
		// the difference of adjacent elements
		int diff[] = new int[n - 1];
		for (int i = 0; i < n - 1; i++)
			diff[i] = arr[i + 1] - arr[i];

		// Now find the maximum sum subarray in diff array
		int max_diff = diff[0];
		for (int i = 1; i < n - 1; i++) {
			if (diff[i - 1] > 0)
				diff[i] += diff[i - 1];
			if (max_diff < diff[i])
				max_diff = diff[i];
		}
		return max_diff;
	}
}
