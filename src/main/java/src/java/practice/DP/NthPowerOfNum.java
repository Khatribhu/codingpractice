package src.java.practice.DP;

public class NthPowerOfNum {

	public static void main(String[] args) {
		System.out.println(nthPowerRecur(2, 10));
	}

	public static int nthPowerRecur(int num, int n) {

		// terminating condition.
		if (n == 0) {
			return 1;
		} else if (n % 2 == 0) {
			return nthPowerRecur(num, n / 2) * nthPowerRecur(num, n / 2);
		} else {
			return num * nthPowerRecur(num, n / 2) * nthPowerRecur(num, n / 2);
		}
	}

	public static int nthPowerRecurVar(int num, int n) {

		int temp;
		// terminating condition.
		if (n == 0) {
			return 1;
		} 
		temp = nthPowerRecur(num, n/2);
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			return num * temp * temp;
		}
	}
	
	public static int nthPowerRecuFloat(int num, int n) {
		int temp;
		if(n == 0) {
			return 1;
		}
		temp = nthPowerRecuFloat(num, n/2);
		if(n % 2 == 0) {
			return temp*temp;
		} else {
			if(n > 0) {
				return num * temp * temp;
			} else {
				return ( temp * temp ) / n;
			}
		}
	}
	
}
