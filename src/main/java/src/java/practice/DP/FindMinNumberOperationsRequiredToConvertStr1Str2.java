package src.java.practice.DP;

public class FindMinNumberOperationsRequiredToConvertStr1Str2 {

	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("Enter first string");
//		String str1 = scn.nextLine();
//		
//		System.out.println("Enter second string");
//		String str2 = scn.nextLine();
//		scn.close();
		String str1 = "aaaaaaaaaaaaaaaaaaaaaaaXaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String str2 = "aaaaaaXaaaaaaaaaaaaaaaaXaaaaaaaaaaaaaaaaaaaaXaaaaaaX";
//		System.out.println(minRequiredOperations(str1, str2));
//		System.out.println(minRequiredOperationsRecur(str1, str2));
//		System.out.println(minRequiredOperationsDP(str1, str2));
	}

	public static int minRequiredOperationsRecur(String str1, String str2) {
		if (str1 == null || str1.length() == 0) {
			return str2.length();
		}

		if (str2 == null || str2.length() == 0) {
			return str1.length();
		}

		if (str1.charAt(0) == str2.charAt(0)) {
			return minRequiredOperationsRecur(str1.substring(1, str1.length()), str2.substring(1, str2.length()));
		}

		// find distance between all three operations.
		int d, u, i;
		d = minRequiredOperationsRecur(str1.substring(1, str1.length()), str2);
		u = minRequiredOperationsRecur(str1.substring(1, str1.length()), str2.substring(1, str2.length()));
		i = minRequiredOperationsRecur(str1, str2.substring(1, str2.length()));

		// return min of three types plus one
		return Math.min(Math.min(d, u), i) + 1;
	}

	public static int minRequiredOperationsDP(String str1, String str2) {
		int matrix[][] = new int[str1.length()+1][str2.length()+1];

		for(int i = 0; i <= str1.length(); i++) {
			matrix[i][0] = i;
		}
		
		for(int i = 0; i <= str2.length(); i++) {
			matrix[0][i] = i;
		}
		
		for(int i = 1; i <= str1.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1];
				} else {
					matrix[i][j] = Math.min(Math.min(matrix[i][j-1], matrix[i-1][j-1]), matrix[i-1][j]) + 1;
				}
			}
		}
		
		return matrix[str1.length()][str2.length()];
	}
}
