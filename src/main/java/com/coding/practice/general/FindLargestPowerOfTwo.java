package com.coding.practice.general;

public class FindLargestPowerOfTwo {

	public static int findLargestPowerOfTwo(int number) {
		number = number | number >> 1;
		number = number | number >> 2;
		number = number | number >> 4;
		number = number | number >> 8;
		
		return number+1>>1;
		
	}
	public static void main(String[] args) {
		System.out.println(findLargestPowerOfTwo(73453500));
	}
}
