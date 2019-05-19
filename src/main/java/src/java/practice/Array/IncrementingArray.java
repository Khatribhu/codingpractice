package src.java.practice.Array;

import java.math.BigInteger;

/**
 * if the input is (1,2,9) then you should update the array to (1,3,0).
 * 
 * @param args
 */
public class IncrementingArray {

	public static void main(String[] args) {
//		int[] arr = { 1, 9, 9, 9, 9, 9, 9, 9 };
		// int[] arr = {1,2,3};
//s		incrementArray(arr);
		// incrementByOneArrayInplace(arr, 1);
		int arr[] = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
				9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
				9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		arr = plusOne(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void incrementArray(int arr[]) {

		StringBuilder strBuild = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			strBuild.append(arr[i]);
		}
		BigInteger bigInteger = new BigInteger(strBuild.toString());
		bigInteger = bigInteger.add(BigInteger.valueOf(1));
		System.out.println(bigInteger.toString());
	}

	public static void incrementByOneArrayInplace(int[] arr, int increment) {
		int incremented = increment;
		for (int i = arr.length - 1; i >= 0; --i) {
			incremented = arr[i] + incremented;
			if (incremented >= 10) {
				arr[i] = incremented % 10;
				incremented /= 10;
			} else {
				arr[i] += increment;
			}
		}
		return;
	}

	public static int[] plusOne(int[] arr) {
		int[] resultArr = new int[arr.length + 1];
		if (arr.length < 5) {
			StringBuilder strBuild = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				strBuild.append(arr[i]);
			}
			Integer bigInteger = Integer.parseInt(strBuild.toString());
			bigInteger++;
			String resultString = bigInteger.toString();
			int[] result = new int[resultString.length()];
			for (int i = 0; i < resultString.length(); i++) {
				result[i] = Character.getNumericValue(resultString.charAt(i));
			}
			return result;
		} else {
			int incremented = 1;
			int j = arr.length;
			for (int i = arr.length - 1; i >= 0; --i) {
				incremented = arr[i] + incremented;
				if (incremented >= 10) {
					arr[i] = incremented % 10;
					resultArr[j--] = incremented % 10;
					incremented /= 10;
				} else {
					arr[i] += incremented;
					incremented = 0;
					break;
				}
				
				if(i == 0 && incremented != 0) {
					resultArr[j--] = arr[i] + 1;
					return resultArr;
				}
			}
			return arr;
		}
	}
	
	
}
