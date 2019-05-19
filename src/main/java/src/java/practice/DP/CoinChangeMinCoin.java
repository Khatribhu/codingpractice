package src.java.practice.DP;

/**
 * Class to find min number of coins required to achieve some sum.
 * 
 * @author bkhatri3
 *
 */
public class CoinChangeMinCoin {
	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		// System.out.println(minNumberOfCoins(11, coins));
		System.out.println(numberOfWaysToCoinChange(4, coins));
		System.out.println(count(coins, 3, 4));

	}

	/**
	 * Method to find minimum number of coins required to get sum.
	 */
	public static int minNumberOfCoins(int n, int[] coins) {
		int dp[] = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					min = Math.min(min, dp[i - coins[j]]);
				}
			}
			dp[i] = min + 1;
		}

		return dp[n];
	}

	/**
	 * Method to count all the permutation possible for given some change using the
	 * given coins.
	 */
	public static int numberOfWaysToCoinChange(int n, int coins[]) {
		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					dp[i] += dp[i - coins[j]];
				}
			}
		}
		return dp[n];
	}

	public static int count(int S[], int m, int n) {
		// table[i] will be storing the number of solutions for
		// value i. We need n+1 rows as the table is constructed
		// in bottom up manner using the base case (n = 0)
		int table[] = new int[n + 1];

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[] values
		// after the index greater than or equal to the value of the
		// picked coin
		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]];

		return table[n];
	}
}
