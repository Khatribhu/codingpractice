package src.java.practice.DP;

public class TwoDarrayMinPath {

	static int mem[][] = new int[3][4];
	
	public static void main(String[] args) {
		int matrix[][] = {{1,3,5,8},
						  {4,2,1,7},
						  {4,3,2,3}
						  };
		System.out.println(minPathCost(matrix,2,3));
		//System.out.println(minPathCostMemorization(matrix, 2,3));
		System.out.println(minPathCostDP(matrix, 2, 3));
	}

	// Top down approach using recursion.
	/**
	 * Allowed to move in two direction right and down.
	 * @author bkhatri3
	 *
	 */
	public static int minPathCost(int[][] matrix, int m, int n) {
		if (m == 0 && n == 0) {
			return matrix[0][0];
		}

		// first row
		if (m == 0) {
			return minPathCost(matrix, m, n - 1) + matrix[0][n];
		}

		// first col
		if (n == 0) {
			return minPathCost(matrix, m - 1, n) + matrix[m][0];
		}

		int x = minPathCost(matrix, m - 1, n);
		int y = minPathCost(matrix, m, n - 1);
		return (Math.min(x, y) + matrix[m][n]);
	}

	// Top down approach using recursion & memorization.
	/**
	 * Allowed to move in two direction right and down.
	 * @author bkhatri3
	 *
	 */
	public static int minPathCostMemorization(int[][] matrix, int m, int n) {
		if (mem[m][n] != 0) {
			return mem[m][n];
		}

		if (m == 0 && n == 0) {
			mem[m][n] = matrix[0][0];
		} else if (m == 0) {
			// first row
			mem[m][n] = minPathCostMemorization(matrix, m, n - 1) + matrix[0][n];
		} else if (n == 0) {
			// first col
			mem[m][n] = minPathCostMemorization(matrix, m - 1, n) + matrix[m][0];
		} else {
			int x = minPathCostMemorization(matrix, m - 1, n);
			int y = minPathCostMemorization(matrix, m, n - 1);
			mem[m][n] = (Math.min(x, y) + matrix[m][n]);
		}

		return mem[m][n];
	}
	
	/**
	 * Allowed to move in two direction right and down.
	 * @author bkhatri3
	 *
	 */
	public static int minPathCostDP(int[][]cost, int m, int n) {
		mem[0][0] = cost[0][0];
		
		for(int i = 1; i <= n; i++) {
			mem[0][i] = mem[0][i-1]+ cost[0][i]; 
		}
		
		for(int i = 1; i <= m; i++) {
			mem[i][0] = mem[i-1][0]+ cost[i][0];
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				mem[i][j] = Math.min(Math.min(mem[i-1][j],mem[i][j-1]),mem[i-1][j-1])+ cost[i][j];
			}
		}
		
		return mem[m][n];
	}
	
	/**
	 * If it can move in three ways right, bottom and diagonally.
	 */
	
}
