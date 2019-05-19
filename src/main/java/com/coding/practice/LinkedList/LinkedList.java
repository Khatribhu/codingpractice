package com.coding.practice.LinkedList;

public class LinkedList {

	public LLNode head = null;

	public LLNode findMiddle(LLNode root) {
		// base case
		if(root == null) {
			return root;
		}
		
		LLNode fastPtr = root.next, slowPtr = root;
		
		while (fastPtr != null) {
			fastPtr = fastPtr.next;
			if (fastPtr != null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}

		}

		return slowPtr;
	}

	public void push(int data) {
		LLNode newLinkedListNode = new LLNode(data);
		newLinkedListNode.next = head;
		head = newLinkedListNode;
	}

	public void printList(LLNode head) {
		LLNode temp = head;
		while (temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public LLNode getTail(LLNode head) {
		LLNode temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}
}