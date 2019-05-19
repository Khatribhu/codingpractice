package src.java.practice.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the longest sub-string with equal number of zeros and one.
 * 
 * @author bkhatri3
 *
 */
public class SubArrayWithEqualZeroAndOne {

	public static void main(String[] args) {
		Integer ar[] = { 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0 };
		List<Integer> list = Arrays.asList(ar);
		findMaxLengthSubString(list);
	}

	// replace zeros with -1 and find largest sub-array with sum 0.
	public static void findMaxLengthSubString(List<Integer> list) {

		// empty hashmap to store ending index of first sub-array having sum sum.
		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, -1);

		// to store max length of sub-array with sum.
		int len = 0;

		// store max index of sub-array with sum.
		int ending_index = -1;

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {

			sum += (list.get(i) == 0 ? -1 : 1);
			if (map.containsKey(sum)) {
				if (len < i - map.get(sum)) {
					len = i - map.get(sum);
					ending_index = i;
					System.out.println("printing len :" + len);
					System.out.println("Ending index of max sum occurance " + ending_index);
				}
			} else {
				map.put(sum, i);
			}
		}
		if (ending_index != -1) {
			System.out.print(ending_index - len + 1 + " ," + ending_index);
		} else {
			System.out.println("No subarray exist");
		}

	}
}
