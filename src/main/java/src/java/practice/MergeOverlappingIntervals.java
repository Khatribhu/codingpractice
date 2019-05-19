package src.java.practice;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {

	static class Interval implements Comparable<Interval> {

		Integer first;
		Integer second;

		public Interval(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Interval o) {
			if (o instanceof Interval) {
				Integer thisValue = this.first;
				Integer oValue = o.first;
				return thisValue.compareTo(oValue);
				// return Integer.compare(this.first, interval.first);
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		Interval arr[] = new Interval[4];
		arr[0] = new Interval(6, 8);
		arr[1] = new Interval(1, 9);
		arr[2] = new Interval(2, 4);
		arr[3] = new Interval(4, 7);
		// mergeOverlappingIntervals(arr);
		mergeOverlappingIntervalsO1(arr);

	}

	/**
	 * Merging using stack. Time : O(nlog n) Space: O(n)
	 * 
	 * @param arr
	 */
	public static void mergeOverlappingIntervals(Interval[] arr) {

		if (arr.length <= 0) {
			return;
		}

		// create empty stack of intervals
		Stack<Interval> stack = new Stack<>();

		// sort the array interval in increasing order of start time.
		Arrays.sort(arr);

		// push first element to the stack
		// if the first element remains on stack means first elements included all the
		// remaining ranges.
		stack.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			// get interval from top of stack
			Interval top = stack.peek();

			// if current element is not overlapping then push again to the stack.
			if (top.second < arr[i].first) {
				stack.push(arr[i]);
			}

			// otherwise update the ending time of the interval with the ending time, if
			// that is more.
			else if (top.second < arr[i].second) {
				top.second = arr[i].second;
				stack.pop();
				stack.push(top);
			}
		}

		System.out.println("Merged intervals are:");
		while (!stack.isEmpty()) {
			Interval t = stack.pop();
			System.out.println("[" + t.first + "," + t.second + "]");
		}

	}

	/**
	 * 
	 * Method using variable. time: O(nlog n) sapce: O(1)
	 * 
	 * @param arr
	 */
	public static void mergeOverlappingIntervalsO1(Interval[] arr) {
		if (arr.length <= 0) {
			return;
		}

		Arrays.sort(arr);
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			// if this is not the first interval and overlaps with previous one.
			if (index != 0 && arr[index - 1].first <= arr[i].second) {
				while (index != 0 && arr[index - 1].first < arr[i].second) {
					// merge previous and current interval.
					arr[index - 1].second = Math.max(arr[index - 1].second, arr[i].second);
					arr[index - 1].first = Math.min(arr[index - 1].first, arr[i].first);
					index--;
				}
			} else {
				// doesn't overlap with previous, include to the solution.
				arr[index] = arr[i];
			}
			index++;
		}

		// now arr store the merged invervals.
		System.out.println("Merged intervals");
		for (int i = 0; i < index; i++) {
			System.out.println("[" + arr[i].first + "," + arr[i].second + "]");
		}
	}
}
