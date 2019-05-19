package com.coding.pratice;

public class FindMaxInInterval {

	public static void main(String[] args) {
		int[] array = { 8,5,7,9,4 };
		printMaxInInterval(array, 3);

	}

	public static void printMaxInInterval(int[] arr, int interval) {
		int max = Integer.MIN_VALUE;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {

			if (j < interval && j < arr.length) {
				if (arr[i] > max) {
					max = arr[i];
				}
				j++;
			}

			if (j == interval) {
				j = 0;
				System.out.print(max);
				i = i - (interval - 1);
				max = Integer.MIN_VALUE;
			}
//			} else if (i == arr.length - 1) {
//				System.out.println(max);
//			}

		}
	}
	
	public static void printMaxInIntervalTwo(int[] arr, int interval) {
		int max = Integer.MIN_VALUE;
		int j = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			if (j < interval && j < arr.length && count > 1) {
				if(arr[i] > max) {
					max = arr[i];
				}
				j++;
				
				//if first element was the max
				if(max == arr[i - interval -2]) {
					
				} else {
					// compare current number with max number available.
					if(arr[i] > max) {
						max = arr[i];
					}
				}
				
				
				
				if (arr[i] > max) {
					max = arr[i];
				}
				j++;
			} else {
				if(arr[i] > max) {
					max = arr[i];
				}
				j++;
			}

			if (j == interval) {
				count++;
				j = 0;
				System.out.print(max);
				i = i - (interval - 1);
				max = Integer.MIN_VALUE;
			}
//			} else if (i == arr.length - 1) {
//				System.out.println(max);
//			}

		}
	}
}
