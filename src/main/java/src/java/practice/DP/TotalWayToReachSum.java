package src.java.practice.DP;

public class TotalWayToReachSum {

	public static void main(String[] args) {
		System.out.println(findMinWaysRecur(13));
		System.out.println(findMinWaysDP(13));
		System.out.println(findMinWaysDPOnePermutation(13));
		
	}

	/**
	 * using 3,5,10
	 * 
	 * @param sum
	 * @return
	 */
	public static int findMinWaysRecur(int sum) {
		if (sum < 0) {
			return 0;
		}
		if (sum == 0) {
			return 1;
		}

		return findMinWaysRecur(sum - 10) + findMinWaysRecur(sum - 5) + findMinWaysRecur(sum - 3);
	}

	/**
	 * All permutations. 3, 5, 10
	 * 
	 * @param sum
	 * @return
	 */
	public static int findMinWaysDP(int sum) {
		int arr[] = new int[sum + 1];
		arr[0] = 1;

		for (int i = 1; i <= sum; i++) {
			if (i - 3 >= 0) {
				arr[i] += arr[i - 3];
			}

			if (i - 5 >= 0) {
				arr[i] += arr[i - 5];
			}

			if (i - 10 >= 0) {
				arr[i] += arr[i - 10];
			}
		}
		return arr[sum];
	}

	/**
	 * 3, 5, 10 Only one permutation combination is taken into consideration.
	 * 
	 * @param sum
	 * @return
	 */
	public static int findMinWaysDPOnePermutation(int sum) {
		// TODO one permutation.
		int arr[] = new int[sum + 1];
		arr[0] = 1;

		for (int i = 1; i <= sum; i++) {
			if (i - 3 >= 0) {
				arr[i] += arr[i - 3];
			}

			if (i - 5 >= 0) {
				arr[i] += arr[i - 5];
			}

			if (i - 10 >= 0) {
				arr[i] += arr[i - 10];
			}
		}
		return arr[sum];
	}

	/**
	 * Combination of 1,3,4.
	 * 
	 * @param n
	 * @return
	 */
	public static int countWay2(int n) {
		int DP[] = new int[n + 1];
		DP[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i - 1 >= 0) {
				DP[i] += DP[i - 1];
			}

			if (i - 3 >= 0) {
				DP[i] += DP[i - 3];
			}

			if (i - 4 >= 0) {
				DP[i] += DP[i - 4];
			}
		}
		return DP[n];
	}

	static int countWaysOtherApproach(int n) {
		int DP[] = new int[n + 1];

		// base cases
		DP[0] = DP[1] = DP[2] = 1;
		DP[3] = 2;

		// iterate for all values from 4 to n
		for (int i = 4; i <= n; i++)
			DP[i] = DP[i - 1] + DP[i - 3] + DP[i - 4];

		return DP[n];
	}
}
