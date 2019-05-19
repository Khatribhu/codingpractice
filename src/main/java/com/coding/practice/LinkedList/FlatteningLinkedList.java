package com.coding.practice.LinkedList;

public class FlatteningLinkedList {

	/*
	 * Sort the all below linked list first then merge each of them with N merge
	 * list.
	 * 
	 * 
	 */

	public static void main(String args[]) {
		HrchyLL hrchyLL = new HrchyLL();

		/*
		 * Let us create the following linked list 5 -> 10 -> 19 -> 28 | | | | V V V V 7
		 * 20 22 35 | | | V V V 8 50 40 | | V V 30 45
		 */

		hrchyLL.head = hrchyLL.push(hrchyLL.head, 30);
		hrchyLL.head = hrchyLL.push(hrchyLL.head, 8);
		hrchyLL.head = hrchyLL.push(hrchyLL.head, 7);
		hrchyLL.head = hrchyLL.push(hrchyLL.head, 5);

		hrchyLL.head.right = hrchyLL.push(hrchyLL.head.right, 20);
		hrchyLL.head.right = hrchyLL.push(hrchyLL.head.right, 10);

		hrchyLL.head.right.right = hrchyLL.push(hrchyLL.head.right.right, 50);
		hrchyLL.head.right.right = hrchyLL.push(hrchyLL.head.right.right, 22);
		hrchyLL.head.right.right = hrchyLL.push(hrchyLL.head.right.right, 19);

		hrchyLL.head.right.right.right = hrchyLL.push(hrchyLL.head.right.right.right, 45);
		hrchyLL.head.right.right.right = hrchyLL.push(hrchyLL.head.right.right.right, 40);
		hrchyLL.head.right.right.right = hrchyLL.push(hrchyLL.head.right.right.right, 35);
		hrchyLL.head.right.right.right = hrchyLL.push(hrchyLL.head.right.right.right, 20);

		// flatten the list
		hrchyLL.head = hrchyLL.flatten(hrchyLL.head);

		hrchyLL.printList();
	}
}

/**
 * Creating the linked list.
 * 
 * @author bkhatri3
 *
 */
class HrchyLL {

	public HrchyNode head;

	/**
	 * Node to support
	 * 
	 * @author bkhatri3
	 *
	 */
	static class HrchyNode {

		public int val;

		public HrchyNode right;

		public HrchyNode down;

		public HrchyNode(int val) {
			this.val = val;
			right = null;
			down = null;
		}
	}

	/**
	 * push element at the beginning of the linked list.
	 */
	public HrchyNode push(HrchyNode headref, int data) {

		// allocate and put the data.
		HrchyNode newNode = new HrchyNode(data);

		newNode.down = headref;
		headref = newNode;
		return headref;
	}

	// utility method to merge two sorted linked list.
	public HrchyNode merge(HrchyNode a, HrchyNode b) {
		// if first linked list is empty then second is answer
		if (a == null) {
			return b;
		}

		// if second is empty then first is answer.
		if (b == null) {
			return a;
		}

		// compare the data members of the two linked list and put the larger one in the
		// result.
		HrchyNode result;

		if (a.val < b.val) {
			result = a;
			result.down = merge(a.down, b);
		} else {
			result = b;
			result.down = merge(a, b.down);
		}

		return result;

	}

	public HrchyNode flatten(HrchyNode root) {

		// base cases.
		if (root == null || root.right == null) {
			return root;
		}

		// recur the list on right
		root.right = flatten(root.right);

		// now merge
		root = merge(root, root.right);

		// return the root
		// it will be in turn merge with its left
		return root;
	}

	void printList() {
		HrchyNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.down;
		}
		System.out.println();
	}
}
