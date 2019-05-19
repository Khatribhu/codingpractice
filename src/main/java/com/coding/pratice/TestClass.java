package com.coding.pratice;

public class TestClass {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		int index = removeDuplicates(arr);
		for (int i = 0; i < index; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int removeDuplicates(int[] arr) {
		int j = 0, count = 0;
		for (int i = 0; i < arr.length;) {
			while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
				i++;
			}
			++count;
			arr[j] = arr[i];
			j++;
			i++;
		}
		return count;
	}
}
