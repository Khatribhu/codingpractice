package src.java.practice.sorting;

public class HeapSort {

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		System.out.println("array before sorting");
		printArray(arr);
		System.out.println();
		sort(arr);
		System.out.println("array after sorting");
		printArray(arr);
	}

	public static void sort(int arr[]) {
		int n = arr.length;

		// build hea( rearrange array )
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		// one by one extract element from the heap
		for (int i = n - 1; i >= 0; i--) {
			// move current root to end
			swap(arr, 0, i);

			// call max heapify on reduced heap
			heapify(arr, i, 0);
		}
	}

	// to heapify a subtree rooted with node i which is a index in arr, n is size of
	// arr
	public static void heapify(int[] arr, int n, int i) {
		int largest = i; // initialize largest as root
		int l = 2 * i + 1; // left = 2*i+1
		int r = 2 * i + 2; // right = 2*i+2

		// if left child is larger than root
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		// if right child is larger than largest so far
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		// if largest is not the root
		if (largest != i) {
			swap(arr, i, largest);

			// recursively heapify the subtree.
			heapify(arr, n, largest);
		}
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void swap(int[] arr, int to, int from) {
		if (to != from && arr[to] != arr[from]) {
			arr[to] = arr[to] + arr[from];
			arr[from] = arr[to] - arr[from];
			arr[to] = arr[to] - arr[from];
		}
	}
}
