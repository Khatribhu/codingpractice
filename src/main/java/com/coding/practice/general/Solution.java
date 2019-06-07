package com.coding.practice.general;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Pattern;

class Parent { 
	Parent(int a, String b) throws ClassCastException {
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
	public static void main(String[] args) throws NoSuchAlgorithmException {	
		

		String str3 = " ABC".trim();
		String str1 = "ABC";
		System.out.println(str1==str3);

				
		Hashtable table = new Hashtable<>();
		table.values().iterator();
		List<String> lsit = new ArrayList<>();
		for(String str : lsit) {
			lsit.remove("asd");
		}
		String s = "";
		StringBuilder strBuild = new StringBuilder();
		MessageDigest digest = MessageDigest.getInstance("MD5");
		byte[] messageDigest = digest.digest(new String().getBytes());
		BigInteger no  = new BigInteger(1, messageDigest);
		String hasText = no.toString();
		while(hasText.length() < 32) {
			hasText = "0"+hasText;
		}
		
		
		Arrays.sort(new int[4]);
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(9);
		list.add(3);
		list.add(1);
		list.add(0);
		Comparator<Integer> cmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		
		
		list.stream().forEach(a -> {
			if(a == 3) {
				int count = 0;
			}
		});
		list.forEach(a -> System.out.println(a));
		
		
	}
}