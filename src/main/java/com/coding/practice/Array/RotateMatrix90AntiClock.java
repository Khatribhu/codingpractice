package com.coding.practice.Array;

/**
 * 
 * @author bkhatri3
 *
 */
public class RotateMatrix90AntiClock {

	public static void main(String[] args) {
		int m = 3, n = 3;
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }};
		int result[][] = new int[n][m];

		System.out.println("Before rotation..");
		printMatrix(matrix, m, n);
		// result = rotate90Degree(matrix, m, n);
		result = rotateWithoutSpace(matrix, m, n);
		System.out.println("\nAfter rotation..");
		printMatrix(result, n, m);

	}

	private static int[][] rotate90Degree(int arr[][], int m, int n) {
		int result[][] = new int[n][m];
		int r = 0, c = 0;
		for (int j = n - 1; j >= 0; j--) {
			for (int i = 0; i < m; i++) {
				result[r][c] = arr[i][j];
				c++;
			}
			r++;
			c = 0;
		}
		return result;
	}

	private static void printMatrix(int arr[][], int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] rotateWithoutSpace(int input[][], int m, int n) {
		int result[][] = transpose(input, m, n);
		for (int j = 0; j < m; j++) {
			for (int k = 0, l = n - 1; k <= l; k++, l--) {
				// reverse the array.
				int temp = result[k][j];
				result[k][j] = result[l][j];
				result[l][j] = temp;
			}
		}
		return result;
	}

	private static int[][] transpose(int input[][], int m, int n) {
		int[][] result = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = input[j][i];
			}
		}
		return result;
	}
}
