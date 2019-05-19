package src.java.practice.Array;

import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElementInArray {

	static Deque<Integer> stack = new LinkedList<>();

	static void printNGE(int arr[], int n) {
		int next, i, j;
		for (i = 0; i < n; i++) {
			next = -1;
			for (j = i + 1; j < n; j++) {
				if (arr[i] < arr[j]) {
					next = arr[j];
					break;
				}
			}
			System.out.println(arr[i] + " -- " + next);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 3, 5, 4, 2, 25 };
		int n = arr.length;
		printNGE(arr, n);
	}

	static void printNextGE(int arr[], int n) {
		stack.push(arr[0]);
		int next, element;

		// iterate over the rest elements
		for (int i = 1; i < n; i++) {
			next = arr[i];
			
			if(!stack.isEmpty()) {
				element = stack.pop();
				
				while(element < next) {
					System.out.println(element+" ---> "+next);
					if(stack.isEmpty()) break;
					element = stack.pop();
				}
				
				if(element > next) {
					stack.push(element);
				}
			}
			
			
			stack.push(next);
		}
		
		// after iterating over the elements, elements in the stack donot have any greater element.
		while(!stack.isEmpty()) {
			element = stack.pop();
			System.out.println(element+" ---> "+ -1);
		}
	}

}
