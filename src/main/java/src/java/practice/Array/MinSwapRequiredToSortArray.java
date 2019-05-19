package src.java.practice.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwapRequiredToSortArray {

	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		System.out.println(findMinSwapsToSort(arr));
	}


	/**
	 * Finds the minimum number of swaps to sort given array in increasing order.
	 * 
	 * @param ar array of <strong>non-negative distinct</strong> integers. input
	 *           array will be overwritten during the call!
	 * @return min no of swaps
	 */
	public static int findMinSwapsToSort(int[] ar) {
		int n = ar.length;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			// adding elements to the map.
			m.put(ar[i], i);
		}
		// sorting the array
		Arrays.sort(ar);
		// updating array with indexes.
		for (int i = 0; i < n; i++) {
			ar[i] = m.get(ar[i]);
		}
		m = null;
		int swaps = 0;
		for (int i = 0; i < n; i++) {
			int val = ar[i];
			if (val < 0)
				continue;
			while (val != i) {
				int new_val = ar[val];
				ar[val] = -1;
				val = new_val;
				swaps++;
			}
			ar[i] = -1;
		}
		return swaps;
	}
}