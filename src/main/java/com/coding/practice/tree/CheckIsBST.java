package com.coding.practice.tree;

public class CheckIsBST {

	// Root of the Binary Tree
	TreeNode root;

	/*
	 * can give min and max value according to your code or can write a function to
	 * find min and max value of tree.
	 */

	/*
	 * returns true if given search tree is binary search tree (efficient version)
	 */
	boolean isBST() {
		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/*
	 * Returns true if the given tree is a BST and its values are >= min and <= max.
	 */
	boolean isBSTUtil(TreeNode node, int min, int max) {
		/* an empty tree is BST */
		if (node == null) {
			return true;
		}

		if (node.value < min || node.value > max) {
			return false;
		}
		
		return (isBSTUtil(node.left, min, node.value - 1) && isBSTUtil(node.right, node.value + 1, max));
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		CheckIsBST tree = new CheckIsBST();
		tree.root = new TreeNode(4);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(5);
		tree.root.left.left = new TreeNode(1);
		tree.root.left.right = new TreeNode(3);

		if (tree.isBST())
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}