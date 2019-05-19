package com.conding.practice.Array;

public class MoveZeros {

	public static void main(String[] args) {
		int arr[] = {1, 0};
		moveZeroes(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void moveZeroes(int[] arr) {

		if (arr.length > 1) {
			for (int i = 0; i < arr.length;) {
				if (arr[i] == 0) {
					int j = i;
					while (j < arr.length && arr[j] == 0) {
							j++;
					}
					
					if(j != arr.length) {
						arr[i] = arr[j];
						arr[j] = 0;
						i++;
					} else {
						i++;
					}
				} else {
					i++;
				}
			}
		}
	}
}
