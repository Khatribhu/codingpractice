package com.coding.practice.general;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

@FunctionalInterface
interface example {
	
	static void methodStatic() {
		System.out.println("static method");
	}
	
	default void methodDefault() {
		System.out.println("executing default");
	}
	
	public void abstractMethod(int val);
}

abstract class abstractClass {
	
	public abstractClass() {
		System.out.println("asdfgvnb");
	}
	
	abstract int abstractMethod();
}


class Parent {
	Parent(int a, String b) throws ClassCastException {
	}

}

class Child extends Parent {

	Child() {
		super(5, "ab");
	}

	Child(int a, String b) {
		super(5, "ab");
	}
}

public class Solution {

	public static void callMethod(Integer l) {
		System.out.println("method with Integer arg");
	}

	public static void callMethod(long l) {
		System.out.println("method with long primitive type");
	}

	Solution() {
		System.out.println("this is constructor");
	}

	static {
		// System.out.println("I am static method");
	}
	private static final Pattern AMPERSAND = Pattern.compile("&");

	public static long F(int N) {
		if (N == 0)
			return 0;
		if (N == 1)
			return 1;
		return F(N - 1) + F(N - 2);
	}

	public static long FiboDP(int n) {
		long secondLast = 0, last = 1;
		long temp = 0;
		for (int i = 2; i < n; i++) {
			temp = last + secondLast;
			secondLast = last;
			last = temp;
		}
		return temp;
	}

	public void method() {
		class a {
			void callMe() {
				System.out.println("calling you");
			}
		}
	}

	public static void main(String[] args) {

		try {
			method1();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void method1() throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println();
			throw new FileNotFoundException("catch excpetion");
			
		} finally {
			System.out.println("finally executing");
			
		}
	}
}