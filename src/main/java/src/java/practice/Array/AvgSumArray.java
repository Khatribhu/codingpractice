package src.java.practice.Array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class AvgSumArray {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 2 };
		printSubArray(arr);
	}

	public static double findAvg(int arr[], int i, int j) {

		if (i == j) {
			return (double) arr[i];
		}
		int sum = 0;
		for (int index = i; index <= j; index++) {
			sum += arr[index];
		}
		return (double) sum / (j - i + 1);
	}

	public static double findAvgRest(int[] arr, int i, int j) {

		int sum = 0;
		for (int index = 0; index < arr.length; index++) {
			if (index < i || index > j) {
				sum += arr[index];
			}
		}

		return (double) sum / (arr.length - ((j - i) + 1));
	}

	public static void printSubArray(int[] arr) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				double val1 = findAvg(arr, i, j);
				double val2 = findAvgRest(arr, i, j);
				if (val1 > val2 || (i == 0 && j == arr.length - 1)) {
					StringBuilder stBuild = new StringBuilder();
					stBuild.append(i + 1);
					stBuild.append(j + 1);
					set.add(stBuild.toString());
				}
			}
		}

		System.out.println(set.size());
		for (String str : set) {
			System.out.println(str.charAt(0) + " " + str.charAt(1));
		}
	}

}
