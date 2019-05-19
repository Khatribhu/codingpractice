package com.coding.practice.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicatingElement {

	public static void main(String[] args) {
		System.out.println(6^6);
		System.out.println(6^2);
		Integer[] arr = {1,2,3,4,5,66,66,7,8,9};
		List<Integer> list = Arrays.asList(arr);
		findDuplicate(list);
	}

	public static void findDuplicate(List<Integer> list) {
		Set<Integer> set = new HashSet<>();
		list.forEach(a -> {
			if(set.contains(a)) {
				System.out.println(a);
			}
			set.add(a);
		});
	}
	
}
