package src.java.practice.sorting;

/**
 * There are four ways to do quick sort. 
 * 1. always take first element 
 * 2. always take last element 
 * 3. take mid element 
 * 4. take a random number as pivot.
 * 
 * key process in quick sort is partition.
 * 
 * @author bkhatri3
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		quickSort(arr, 0, arr.length - 1);
		printArray(arr);
	}

	/**
	 * Main method to implement quick sort
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is the partitioning index and arr[pi] at its right place
			 */
			int pi = partition(arr, low, high);

			// recursively sort the element before and after partition.
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi, high);
		}
	}

	/**
	 * 
	 * taking array last element as pivot and arranging to its location. this method
	 * is called as lomuto partition scheme
	 * 
	 */
	public static int partition(int[] arr, int low, int high) {
		// taking pivot element as last element.
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			// if current element if smaller than or equal to pivot swap.
			if (arr[j] <= pivot) {
				i++;
				// swap arr[i] and arr[j]
				swap(arr, i, j);
			}
		}

		// swap arr[i+1] and arr[high] or pivot element, hence making all element at
		// left less than pivot element
		swap(arr, i + 1, high);
		return i + 1;
	}

	public static void swap(int[] arr, int to, int from) {
		if (to != from && arr[to] != arr[from]) {
			arr[to] = arr[to] + arr[from];
			arr[from] = arr[to] - arr[from];
			arr[to] = arr[to] - arr[from];
		}
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
