package src.java.practice.sorting;

/**
 * 
 * @author bkhatri3 Since Java 7 release, default sorting algorithm used is
 *         DualPivotQuickSort. Dual pivot quick sort is combination of quick
 *         sort and insertion sort. insertion sort has faster runtime when
 *         number of elements is less, dual pivot quick sort uses this fact thus
 *         number of elements less than 47 Java uses insertion sort.
 * 
 *         When number greater than 47 it uses Dual pivot quick sort.
 */
public class QuickSortDualPivot {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5, 10, 7, 8, 9, 1, 5, 10, 7, 8, 9, 1, 5, 10, 7, 8, 9, 1, 5, 10, 7, 8, 9, 1, 5, 10,
				7, 8, 9, 1, 5, 10, 7, 8, 9, 1, 5 };
		System.out.println(arr.length);
		sort(arr);
		printArray(arr);
	}

	public static void sort(int[] arr) {
		DPQSort(arr, 0, arr.length - 1);
	}

	public static void DPQSort(int[] arr, int low, int high) {
		rangeCheck(arr.length, low, high);
		dualPivotQuickSort(arr, low, high, 3);
	}

	public static void rangeCheck(int length, int low, int high) {

		if (low > high) {
			// illegal argument exception
			System.out.println("Exception");
		}

		if (low < 0) {
			// index out of bound exception
			System.out.println("Exception");
		}
		if (high > length) {
			// index out of bound
			System.out.println("Exception");
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void insertionSort(int arr[], int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			for (int j = i; j > left && arr[j] < arr[j - 1]; j--) {
				swap(arr, j, j - 1);
			}
		}
	}

	public static void dualPivotQuickSort(int[] arr, int left, int right, int div) {
		int len = right - left;

		if (len < 27) { // insertion sort for tiny array
			insertionSort(arr, left, right);
			return;
		}

		int third = len / div;

		// Medians
		int m1 = left + third;
		int m2 = right - third;

		// if first median is less than left.
		if (m1 <= left) {
			m1 = left + 1;
		}

		// if second median is greater than right
		if (m2 >= right) {
			m2 = right - 1;
		}

		if (arr[m1] < arr[m2]) {
			swap(arr, m1, left);
			swap(arr, m2, right);
		} else {
			swap(arr, m1, right);
			swap(arr, m2, left);
		}

		// pivot
		int pivot1 = arr[left];
		int pivot2 = arr[right];

		// pointers
		int less = left + 1;
		int great = right - 1;

		// sorting
		for (int k = less; k <= great; k++) {
			if (arr[k] < pivot1) {
				swap(arr, k, less++);
			} else if (arr[k] > pivot2) {
				while (k < great && arr[great] > pivot2) {
					great--;
				}
				swap(arr, k, great--);

				if (arr[k] < pivot1) {
					swap(arr, k, less++);
				}
			}
		}

		// swaps
		int dist = great - less;

		if (dist < 13) {
			div++;
		}
		swap(arr, less - 1, left);
		swap(arr, great + 1, right);

		// sub-arrays
		dualPivotQuickSort(arr, left, left - 2, div);
		dualPivotQuickSort(arr, great + 2, right, div);

		// equal elements
		if (dist > len - 13 && pivot1 != pivot2) {
			for (int k = less; k <= great; k++) {
				if (arr[k] == pivot1) {
					swap(arr, k, less++);
				} else if (arr[k] == pivot2) {
					swap(arr, k, great--);
					if (arr[k] == pivot1) {
						swap(arr, k, less++);
					}
				}
			}
		}
		// subarray
		if (pivot1 < pivot2) {
			dualPivotQuickSort(arr, less, great, div);
		}
	}
}
