package src.java.practice.sorting;

import src.java.practice.LinkedList.LLNode;
import src.java.practice.LinkedList.LinkedList;

public class QuickSortSingleLinkedList {
	LinkedList li = new LinkedList();

	public static void main(String[] args) {
		QuickSortSingleLinkedList linkedList = new QuickSortSingleLinkedList();
		linkedList.sortLinkedList();
	}

	public void sortLinkedList() {
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
		li.head = quickSort(li.head, li.getTail(li.head));
		System.out.println("Linked List after sorting is :");
		li.printList(li.head);
	}

	public LLNode quickSort(LLNode head, LLNode tail) {
		return quickSortRecur(head, tail);
	}

	public LLNode partition(LLNode head, LLNode end, LLNode[] arrayOfNode) {
		LLNode pivot = end;
		LLNode prev = null, cur = head, tail = pivot;
		LLNode newHead = arrayOfNode[0], newEnd = arrayOfNode[1];

		// during this partition both head and end of the list might change
		// which is updated in the newHead and newEnd variable
		while (cur != null && pivot != null && cur != pivot) {
			if (cur.val < pivot.val) {
				// first node that has value less than pivot becomes new head
				if (newHead == null) {
					newHead = cur;
				}
				prev = cur;
				cur = cur.next;
			} else { // if cur node is greater than pivot
				// move current node to next of tail and change tail
				if (prev != null) {
					prev.next = cur.next;
				}
				LLNode tmp = cur.next;
				cur.next = null;
				tail.next = cur;
				tail = cur;
				cur = tmp;
			}
		}

		// if the pivot data is smallest element in current list, pivot becomes the head
		if (newHead == null) {
			newHead = pivot;
		}

		// update newEnd to current last node
		newEnd = tail;

		arrayOfNode[0] = newHead;
		arrayOfNode[1] = newEnd;
		return pivot;
	}

	public LLNode quickSortRecur(LLNode head, LLNode tail) {
		// boundary condition
		if (head == null || head == tail) {
			return head;
		}

		LLNode newHead = null, newTail = null;
		LLNode[] arrayOfNode = new LLNode[2];
		arrayOfNode[0] = newHead;
		arrayOfNode[1] = newTail;
		LLNode pivot = partition(head, tail, arrayOfNode);

		newHead = arrayOfNode[0];
		newTail = arrayOfNode[1];
		// if pivot is smaller element no need to recur for left part
		if (newHead != pivot) {
			// set the node before pivot as null
			LLNode temp = newHead;
			while (temp.next != pivot) {
				temp = temp.next;
			}
			temp.next = null;

			// recur the list before pivot
			newHead = quickSortRecur(newHead, temp);

			// change the next of last node of the left half to pivot
			temp = li.getTail(newHead);
			temp.next = pivot;
		}

		// recur the list after pivot element
		pivot.next = quickSortRecur(pivot.next, newTail);
		return newHead;
	}
}
