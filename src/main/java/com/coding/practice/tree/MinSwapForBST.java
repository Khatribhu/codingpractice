package com.coding.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class MinSwapForBST {

	TreeNode root;

	public MinSwapForBST() {

	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		MinSwapForBST tree = new MinSwapForBST();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(6);
		tree.root.right = new TreeNode(7);
		tree.root.left.left = new TreeNode(8);
		tree.root.left.right = new TreeNode(9);
		tree.root.right.left = new TreeNode(10);
		tree.root.right.right = new TreeNode(11);

		System.out.println("Min swaps required to create bst: " + tree.convertBTtoBST(tree.root));
	}

	public int convertBTtoBST(TreeNode root) {
		// first take the inorder tree traversal and save into array.
		List<Integer> list = new ArrayList<>();
		inOrderTraversalCheckingBST(root, list, 0, 0);
		Integer[] arr = list.toArray(new Integer[0]);
		printArray(arr);
		return swaps(arr);

	}
	
	public void printArray(Integer[] arr) {
		for(Integer val : arr) {
			System.out.print(val+ ", ");
		}
	}

	public int swaps(Integer[] arr) {
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					count++;
				}
			}
		}

		return count;
	}

	public static void swap(Integer[] list, int one, int two) {
		int temp = list[one];
		list[one] = list[two];
		list[two] = temp;
	}

	public void inOrderTraversalCheckingBST(TreeNode node, List<Integer> list, int index, int count) {
		if (node == null) {
			return;
		}

		if (node.left != null) {
			inOrderTraversalCheckingBST(node.left, list, index, count);
		}

		list.add(node.value);
//		if (index >= 1 && arr[index] < arr[index - 1]) {
//			count++;
//		}
//		arr[index] = node.value;
//		index++;

		if (node.right != null) {
			inOrderTraversalCheckingBST(node.right, list, index, count);
		}

	}

	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}
}
