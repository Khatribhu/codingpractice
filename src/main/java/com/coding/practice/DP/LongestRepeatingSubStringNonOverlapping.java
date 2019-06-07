/**
 * 
 */
package com.coding.practice.DP;

/**
 * @author bkhatri3
 *
 */
public class LongestRepeatingSubStringNonOverlapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestRepeatedSubstring("banana"));
	}

	static String longestRepeatedSubstring(String str) {
		int n = str.length();
		int LCSRe[][] = new int[n + 1][n + 1];

		String res = ""; // To store result
		int res_length = 0; // To store length of result

		// building table in bottom-up manner
		int i, index = 0;
		for (i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				//  LCSRe[i-1][j-1] < (j - i) to remove
				// overlapping, as (j - 1) if the current word length.
				if (str.charAt(i - 1) == str.charAt(j - 1) && LCSRe[i - 1][j - 1] < (j - i)) {
					LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1;

					// updating maximum length of the
					// substring and updating the finishing
					// index of the suffix
					if (LCSRe[i][j] > res_length) {
						res_length = LCSRe[i][j];
						index = Math.max(i, index);
					}
				} else {
					LCSRe[i][j] = 0;
				}
			}
		}

		// If we have non-empty result, then insert all
		// characters from first character to last
		// character of String
		if (res_length > 0) {
			for (i = index - res_length + 1; i <= index; i++) {
				res += str.charAt(i - 1);
			}
		}

		return res;
	}
}
