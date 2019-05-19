package com.coding.practice.general;

public class SumOfNumArray {

	public static void main(String[] args) {
		ArrayClass obj = new ArrayClass();
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		obj.setArr(arr);
		updateArrayWithSum(obj, 0, 0);
		arr = obj.getArr();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void updateArrayWithSum(ArrayClass obj, int sum, int index) {
		int[] arr = null;
		if (obj != null) {
			arr = obj.getArr();
		}
		if (arr != null && arr.length > 0) {

			// terminating condition.
			if (index == arr.length) {
				return;
			}

			sum += arr[index];
			arr[index] = sum;
			updateArrayWithSum(obj, sum, ++index);
		}
		return;
	}
}

class ArrayClass {
	private int[] arr;

	public void setArr(int[] array) {
		this.arr = array;
	}

	public int[] getArr() {
		return arr;
	}

}
