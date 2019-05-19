package src.java.practice.DP;

public class MaxSumSubArray {

	public static void main(String[] args) {
		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(findMaxSumSubArray(arr));
		System.out.println(findMaxSumSubArrayKadane(arr));
		
	}

	public static int findMaxSumSubArray(int arr[]) {
		int maxSum = 0, tempSum = 0;

		for (int i = 0; i < arr.length; i++) {
			tempSum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				// tempsum holds sum of all the elements from i to j.
				tempSum += arr[j];
				if (tempSum > maxSum) {
					maxSum = tempSum;
				}
			}
		}
		if (maxSum == 0) {
			return max(arr);
		}
		return maxSum;
	}

	public static int max(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	/**
	 * Kadane algorithm.
	 */
	public static int findMaxSumSubArrayKadane(int [] arr) {
		int maxSumSoFar = 0, maxSumEndingHere = 0;
		for(int i = 0; i < arr.length; i++) {
			maxSumEndingHere += arr[i];
			
			if(maxSumEndingHere < 0) {
				maxSumEndingHere = 0;
			}
			
			if(maxSumEndingHere > maxSumSoFar) {
				maxSumSoFar = maxSumEndingHere;
			}
		}
		return maxSumSoFar;
	}
	
}
