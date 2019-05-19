package com.coding.practice.DP;

public class FindSumCombinationNIntegers {

	public static void main(String[] args) {
		//System.out.println(findWays(5, 3));
		System.out.println(binomialCoeff(4,2));
	}

	public static int findWays(int n, int k) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		int sum = 0;
		for (int i = k; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				dp[i] += dp[i - j];
			}
		}
		return dp[n];
	}

	/**
	 * Return the binomial coefficient of C(n,k)
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static int binomialCoeff(int n, int k) {
		int c[][] = new int[n + 1][k + 1];

		// calculate the binomial coefficient in bottom up manner.
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if(j == 0 || j == i) {
					c[i][j] = 1;
				} else {
					//calculate the values using previous stored values.
					c[i][j] = c[i-1][j-1] + c[i-1][j];
				}
			}
		}
		
		return c[n][k];
	}
}
