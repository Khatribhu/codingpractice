package com.conding.practice.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortBinaryArray {

	public static void main(String args[]) {
		Integer arr[] = {0,0,1,0,1, 0,0, 0,1,0};
		List<Integer> list = Arrays.asList(arr);
		sortBinaryArray(list);
	}

	public static void sortBinaryArray(List<Integer> arr) {
		
		for (int i = 0, j = arr.size() - 1; i <= j; ) {
			if(arr.get(i) > arr.get(j)) {
				Collections.swap(arr, i, j);
				i++;
				j--;
			} else if(arr.get(i) == arr.get(j)) {
				if(arr.get(i) == 1) {
					j--;
				} else {
					// move i
					i++;
				}
			}
			else {
				i++;j--;
			}
		}
		
		arr.forEach(a -> { System.out.print(" , "+a);});
	}
	
	public static void swap(List<Integer> list, int i, int j) {
		Collections.swap(list, i, j);
	}
}
