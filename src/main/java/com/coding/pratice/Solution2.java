package com.coding.pratice;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.coding.pratice.classB.normalClass;

public class Solution2 {

	static class object implements Comparable<object> {
		Integer index;
		Integer value;

		public Integer getValue() {
			return value;
		}

		public Integer getIndex() {
			return index;
		}

		public void setIndex(Integer index) {
			this.index = index;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		@Override
		public int compareTo(object obj) {
			return this.getValue().compareTo(obj.getValue());
		}

	}

	public static void main(String[] args) {
	
		
		classB obj = new classB();
		
		classB.staticNestedClass classObj = new classB.staticNestedClass();
		classB.normalClass normalObj = obj.new normalClass();
		
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner scn = new Scanner(System.in);
		Set<object> set = new TreeSet();
		int n = scn.nextInt();
		for (int i = 1; i <= n; i++) {
			int orderTime = scn.nextInt();
			int prepareTime = scn.nextInt();
			object ob = new object();
			ob.value = orderTime + prepareTime;
			ob.index = i;
			set.add(ob);
		}

		// Collections.sort(set);
//		for (object obj : set) {
//			System.out.print(obj.index + " ");
//		}

	}
}


class classB {
	
	private static int variableOfClass = 99;
	
	private String classB = "class b variable";
	
	static class staticNestedClass {
		
		int val = 0;
		
		public String name = "hero";
		
		public staticNestedClass() {
			System.out.println("creating object of nested class");
		}
		
		public void methodCall() {
			System.out.println("calling method inside static class");
			System.out.println("using parentt class variable,"+ variableOfClass);
		}
	}
	
	public class normalClass extends staticNestedClass {
		public normalClass() {
			System.out.println("creating object of normal nested class");
		}
	}
}