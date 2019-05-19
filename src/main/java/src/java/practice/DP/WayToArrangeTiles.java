package src.java.practice.DP;

/**
 * Tilling problem.
 * @author bkhatri3
 *
 */
public class WayToArrangeTiles {

	public static void main(String[] args) {

		System.out.println(waysToArrange(5));
		System.out.println(wayToArrangeDP(5));
	}

	/**
	 * when size 2*n
	 * @param n
	 * @return
	 */
	public static int waysToArrange(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return waysToArrange(n - 1) + waysToArrange(n - 2);
	}
	
	//using DP
	/**
	 * When size is 2*n
	 * @param n
	 * @return
	 */
	public static int wayToArrangeDP(int n) {
		int last = 2, secondLast = 1, current = 0;

		if (n == 0 || n == 1 || n == 2) {
			return n;
		}

		for (int i = 3; i <= n; i++) {
			current = last + secondLast;
			secondLast = last;
			last = current;
		}
		return current;
	}
	
	public static int wayToArrange3N(int n) {
		// TODO find a solution to arrange 2N tiles in 3N area.
		return 0;
	}
}