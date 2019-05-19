package com.coding.practice.DP;

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		System.out.println(minEditDistance(str1.toLowerCase(), str2.toLowerCase()));
	}

	public static int minEditDistance(String str1, String str2) {

		int len1 = str1.length();
		int len2 = str2.length();

		int dp[][] = new int[len2 + 1][len1 + 1];
		//filling first row
		for (int i = 0; i <= len1; i++) {
			dp[0][i] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[j][0] = j;
		}

		for (int i = 1; i <= len2; i++) {
			for (int j = 1; j <= len1; j++) {
				if (str2.charAt(i-1) == str1.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i - 1][j - 1]) + 1;
				}
			}
		}

		return dp[len2][len1];
	}
}
