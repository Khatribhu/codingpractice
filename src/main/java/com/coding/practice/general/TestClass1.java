package com.coding.practice.general;

import java.util.Scanner;

class TestClass1 {
	public static void main(String args[]) throws Exception {
		Scanner scn = new Scanner(System.in);
		// int t = scn.nextInt();
		// for (int i = 0; i < t; i++) {
//			int n = scn.nextInt();
//			int rotation = scn.nextInt();
//			int arr[] = new int[n];
//			for (int j = 0; j < n; j++) {
//				arr[j] = scn.nextInt();
//			}
//			scn.close();
//			// arr = rotateByNum(arr, rotation);
//
//			// rotate array
//
//			int placeToRotate = rotation % arr.length;
//			for (int j = 0; j < placeToRotate; j++) {
//			//	rotateByOne(arr);
//			}

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		rightRotate(arr, 3, arr.length);
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
			// }
		}
	}

	public static int[] rotateByNum(int[] arr, int num) {
		int size = arr.length;
		int placeToRotate = num % size;
		int[] temp = new int[placeToRotate];
		int k = 0;
		for (int i = size - placeToRotate; i < size; i++) {
			temp[k] = arr[i];
			k++;
		}
		for (int i = size - placeToRotate - 1; i >= 0; i--) {
			arr[i + placeToRotate] = arr[i];
		}

		for (int i = 0; i < placeToRotate; i++) {
			arr[i] = temp[i];
		}
		return arr;
	}

	public static void rotateByOne(int[] arr) {
		int temp = 0;
		int size = arr.length;
		temp = arr[size - 1];
		for (int i = size - 1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}

	public static int gcd(int n, int m) {
		if (m == 0) {
			return n;
		} else {
			return gcd(m, n % m);
		}
	}

	public static void rightRotate(int[] arr, int d, int n) {
		int size = arr.length;
		for (int gcd = gcd(d, n); gcd > 0; gcd--) {
			int index = size - gcd;
			int temp = arr[index];
			int k;
			while (true) {
				if (index <= 0) {
					break;
				}
				k = index - gcd;
				arr[index] = arr[k];
				
				arr[index] = temp;
				index = k;
			}
			
		}

	}
}
