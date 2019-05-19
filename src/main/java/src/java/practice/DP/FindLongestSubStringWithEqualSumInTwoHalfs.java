package src.java.practice.DP;

public class FindLongestSubStringWithEqualSumInTwoHalfs {

	public static void main(String[] args) {
		// System.out.println(maxSubStringLength("9430723"));
		System.out.println(maxSubStringLengthDP("9430723"));
	}

	public static int findStringSum(String str) {
		int firstHalf = 0, secondHalf = 0;
		for (int i = 0; i < str.length() / 2; i++) {
			firstHalf += str.charAt(i);
		}

		for (int i = str.length() / 2; i < str.length(); i++) {
			secondHalf += str.charAt(i);
		}

		if (firstHalf == secondHalf) {
			return str.length();
		}
		return 0;
	}

	public static int maxSubStringLength(String subString) {
		int length = subString.length();
		int max_len = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 2; j <= length; j += 2) {
				int x = findStringSum(subString.substring(i, j));
				if (x > max_len) {
					max_len = x;
				}
			}
		}
		return max_len;
	}

	static int sum[][] = new int[7][7];

	public static int maxSubStringLengthDP(String str) {
		int n = str.length();
		int maxLen = 0;

		// lower diagonal of matrix is not used. ( i > j)
		// filling diagonal values;
		for (int i = 0; i < n; i++) {
			sum[i][i] = Character.getNumericValue(str.charAt(i));
		}
		printMatrix(sum);

		for (int len = 2; len < n; len++) {
			// pick i and j from current substring;
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				int k = len / 2;

				// calculate value of sum[i][j]
				System.out.println(i + " " + (j - k) + " :: " + (j - k + 1) + " " + j + " = " + i + "," + j);

				sum[i][j] = sum[i][j - k] + sum[j - k + 1][j];

				// updates if len is even, left and right are the same and sum is more then
				// max_len
				if (len % 2 == 0 && (sum[i][j - k] == sum[j - k + 1][j]) && len > maxLen) {
					System.out.println("Success");
					System.out.println(sum[i][j - k] + " " + sum[j - k + 1][j]);
					System.out.println(i + " " + (j - k) + " :: " + (j - k + 1) + " " + j);
					maxLen = len;
				}
			}
		}
		// printMatrix(sum);
		return maxLen;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "      ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
