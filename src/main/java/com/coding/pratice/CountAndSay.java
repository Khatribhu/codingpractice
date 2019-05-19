package com.coding.pratice;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSayBK(8));
	}

	public static String countAndSayBK(int n) {
		if (n <= 1) {
			return "1";
		}
//		if (n == 2) {
//			return "11";
//		}

		String tmp = "";
		String str = "1";

		for (int i = 2; i <= n; i++) {
			tmp = "";
			int cnt = 1;
			str += '$';
			int len = str.length();
			char[] arr = str.toCharArray();
			for (int j = 1; j < len; j++) {
				if (arr[j] != arr[j - 1]) {
					tmp += cnt + 0;
					tmp += arr[j - 1];

					// reset the count.
					cnt = 1;
				} else {
					cnt++;
				}
			}
			str = tmp;
		}
		return str;
	}
	public static String countAndSay(int n) {
		if (n <= 1) {
			return "1";
		}
		if (n == 2) {
			return "11";
		}

		String tmp = "";
		String str = "11";

		for (int i = 3; i <= n; i++) {
			tmp = "";
			int cnt = 1;
			str += '$';
			int len = str.length();
			char[] arr = str.toCharArray();
			for (int j = 1; j < len; j++) {
				if (arr[j] != arr[j - 1]) {
					tmp += cnt + 0;
					tmp += arr[j - 1];

					// reset the count.
					cnt = 1;
				} else {
					cnt++;
				}
			}
			str = tmp;
		}
		return str;
	}

	static String countnndSay(int n) {
		// Base cases
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";

		// Find n'th term by generating
		// all terms from 3 to n-1.
		// Every term is generated
		// using previous term

		// Initialize previous term
		String str = "11";
		for (int i = 3; i <= n; i++) {
			// In below for loop, previous
			// character is processed in
			// current iteration. That is
			// why a dummy character is
			// added to make sure that loop
			// runs one extra iteration.
			str += '$';
			int len = str.length();

			int cnt = 1; // Initialize count
							// of matching chars
			String tmp = ""; // Initialize i'th
								// term in series
			char[] arr = str.toCharArray();

			// Process previous term
			// to find the next term
			for (int j = 1; j < len; j++) {
				// If current character
				// does't match
				if (arr[j] != arr[j - 1]) {
					// Append count of
					// str[j-1] to temp
					tmp += cnt + 0;

					// Append str[j-1]
					tmp += arr[j - 1];

					// Reset count
					cnt = 1;
				}

				// If matches, then increment
				// count of matching characters
				else {
					cnt++;
				}
			}

			// Update str
			str = tmp;
		}

		return str;
	}
}
