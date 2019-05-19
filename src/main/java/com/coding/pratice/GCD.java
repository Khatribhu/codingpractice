package com.coding.pratice;

public class GCD {

	public static void main(String[] args) {
		System.out.println(calculateGCD(5,15));
	}
	
	public static int calculateGCD(int x, int y) {
		if(y == 0) return x;
		int p = x % y;
		return calculateGCD(y, p);
	}
	
}
