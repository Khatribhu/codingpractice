package com.coding.practice.Array;

import java.util.ArrayList;
import java.util.List;

public class CanReachEnd {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(3);
		list.add(1);
		list.add(0);
		list.add(2);
		list.add(0);
		list.add(1);
		System.out.println(canReachEnd(list));
		
	}

	public static boolean canReachEnd(List<Integer> maxAdvanceSteps) {
		int furthestReachSoFar = 0, lastlndex = maxAdvanceSteps.size() - 1;
		for (int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastlndex; ++i) {
			furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
		}
		return furthestReachSoFar >= lastlndex;
	}

}
