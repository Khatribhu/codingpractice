
package src.java.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

class Parent { 
	Parent(int a, String b) {
		
	}

}

class Child extends Parent {
	
	Child() {
		super(5,"ab");
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
		//System.out.println("I am static method");
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

		
		System.out.println("khatri");
		Integer arr[] = { 1,2,3,4,5,6,6,8,9};
		List<Integer> arrayList = Arrays.asList(arr);
		int val = 0;
		arrayList.forEach( a -> System.out.println(a));
		
		System.out.println("start");
		System.out.println(val);
		System.out.println("end");
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int randomNum = rand.nextInt(3) + 3;
			System.out.println(randomNum);
		}
		System.out.println("-----Random number ends-----");
		String arch = System.getProperty("sun.arch.data.model");
		if (arch != null) {
			if (arch.contains("32")) {
				// If exists and is 32 bit then we assume a 32bit JVM
				System.out.println("system is 32 bit.");
			} else {
				System.out.println("system is not 32 bit it is:" + arch);

			}
		}
		for (int N = 0; N < 100; N++) {
			System.out.println("DP: " + N + " " + FiboDP(N));	
			// System.out.println(N + " " + F(N));
		}

		int[] array = { 2, 3, 5, 6, 243, 45 };
	}
}