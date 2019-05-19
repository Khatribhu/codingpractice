package src.java.practice.sorting;

import src.java.practice.LinkedList.LLNode;
import src.java.practice.LinkedList.LinkedList;

class MergeSortLinkedList {
	LinkedList list = new LinkedList();

	public void createLinkedListAndSort() {
		LinkedList li = new LinkedList();
		/*
		 * Let us create a unsorted linked lists to test the functions Created lists
		 * shall be a: 2->3->20->5->10->15
		 */
		li.push(15);
		li.push(10);
		li.push(5);
		li.push(20);
		li.push(3);
		li.push(2);
		System.out.println("Linked List without sorting is :");
		li.printList(li.head);
		// Apply merge Sort
		li.head = mergeSort(li.head);
		System.out.println("Linked List after sorting is :");
		li.printList(li.head);
	}

	public LLNode mergeSort(LLNode head) {

		// base case
		if (head == null || head.next == null) {
			return head;
		}

		// get middle of the list
		LLNode middle = list.findMiddle(head);
		LLNode nextOfMiddle = middle.next;

		// set next of middle to null
		middle.next = null;

		// apply merge sort on left list
		LLNode left = mergeSort(head);

		// apply merge sort on right list
		LLNode right = mergeSort(nextOfMiddle);

		// merge left and right list
		LLNode sortedList = sortedMerge(left, right);
		return sortedList;

	}

	public LLNode sortedMerge(LLNode left, LLNode right) {
		LLNode result = null;

		// base case
		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}

		if (left.val <= right.val) {
			result = left;
			result.next = sortedMerge(left.next, right);
		} else {
			result = right;
			result.next = sortedMerge(left, right.next);
		}

		return result;
	}

	public static void main(String[] args) {
		MergeSortLinkedList createLinkedListAndSort = new MergeSortLinkedList();
		createLinkedListAndSort.createLinkedListAndSort();
	}
}