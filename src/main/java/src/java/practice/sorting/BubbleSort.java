package src.java.practice.sorting;

/**
 * Bubble sort is simplest sorting algorithm that works by repeatedly swapping
 * adjacent elements if they are in wrong order
 * 
 * @author bkhatri3
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 13, -15, 24 };
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void bubbleSort(int[] arr) {
		int size = arr.length;
		boolean swapped = false;
		for (int i = 0; i < size; i++) {
			swapped = false;
			for (int j = 0; j < size - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap elements j and j+1
					swap(arr, j + 1, j);
					swapped = true;
				}
			}
			if (!swapped) {
				System.out.println("already sorted");
				break;
			}
		}
	}

	/**
	 * recursive method to do bubble sort
	 * 
	 * @param arr
	 * @param n
	 */
	public static void bubbleSortRecur(int arr[], int n) {
		if (n == 0) {
			return;
		}

		for (int j = 0; j < n - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				// swap j and j+1
				swap(arr, j, j + 1);
			}
		}
		bubbleSortRecur(arr, n - 1);
	}

	public static void swap(int arr[], int one, int two) {
		int temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}
}