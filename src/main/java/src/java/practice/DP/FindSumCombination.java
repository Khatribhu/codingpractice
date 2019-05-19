package src.java.practice.DP;

public class FindSumCombination {

	/*
	 * Problem : Let us say that you are given a number N, you've to find the number
	 * of different ways to write it as the sum of 1, 3 and 4.
	 * 
	 * For example, if N = 5, the answer would be 6.
	 * 
	 * 1 + 1 + 1 + 1 + 1 
	 * 1 + 4 
	 * 4 + 1 
	 * 1 + 1 + 3 
	 * 1 + 3 + 1 
	 * 3 + 1 + 1
	 */

	public static void main(String[] args) {
		findPermuations(5);
	}

	public static int findPermuations(int val) {
		int dp[] = new int[val + 1];
		dp[0] = dp[1] = dp[2] = 1;
		dp[3] = 2;

		for (int i = 4; i <= val; i++) {
			dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
		}

		System.out.println(dp[val]);
		return dp[val];
	}
}
