package src.java.practice.searching;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 10, 7, 8, 9, 1, 5 };
		binarySearch(arr, 0, arr.length, 10);
	}

	public static void binarySearch(int[] arr, int start, int end, int element) {
		int mid = (start + end) / 2;
		if (start < end) {
			if (element == arr[mid]) {
				System.out.println("element found at index : " + mid);
				return;
			} else if (arr[mid] > element) {
				binarySearch(arr, mid + 1, end, element);
			} else {
				binarySearch(arr, start, mid - 1, element);
			}
		}

	}
}
