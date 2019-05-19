package com.coding.practice.DP;

public class EggDropping {

	public static void main(String args[]) {
		int n = 2, k = 10;
		System.out.println("Minimum number of " + "trials in worst case with " + n + " eggs and " + k + " floors is "
				+ eggDrop(n, k));

		System.out.println("--DP--");
		System.out.print("Minimum number of " + "trials in worst case with " + n + " eggs and " + k + " floors is "
				+ eggDropDP(n, k));
	}

	public static int eggDrop(int n, int k) {

		// if there are no floors no trials, if one floors 1 trial.
		if (k == 1 || k == 0) {
			return k;
		}

		// we need k tried for i egg and k floors.
		if (n == 1) {
			return k;
		}

		int min = Integer.MAX_VALUE;
		int x, res;

		/*
		 * take one by one each floor and check both cases use min of both. 
		 * 1. when egg breaks: check k -1 floors with n-1 eggs. 
		 * 2. when egg doesn't: check k - x floors with n eggs.
		 */
		for (x = 1; x <= k; x++) {
			res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
			if (res < min) {
				min = res;
			}
		}
		return min + 1;
	}

	/**
	 * Solving problem using DP where there are n eggs and k floors
	 */
	public static int eggDropDP(int n, int k) {

		int dp[][] = new int[n + 1][k + 1];

		// checking the base case when there is only k floors return and 0 egg
		for (int i = 1; i <= k; i++) {
			dp[1][i] = i;
		}

		// when there are n egg but floors are 0 and 1.
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;
		}

		int res;
		// checking for other cases using optimistic subproblem.
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= k; j++) {

				// for every case we are taking all the possible cases like one when egg drops
				// and other when doesn't
				dp[i][j] = Integer.MAX_VALUE;
				for (int x = 1; x <= j; x++) {
					res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
					if (res < dp[i][j]) {
						dp[i][j] = res;
					}
				}
			}
		}

		return dp[n][k];
	}

}
