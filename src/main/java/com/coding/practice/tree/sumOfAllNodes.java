package com.coding.practice.tree;

public class sumOfAllNodes {

	public static void main(String[] args) {
		BinaryTree bTree = null;
		bTree = createTree();
		System.out.println("post order tree traversal");
		traverse(bTree.root);
		addChildSum(bTree.root);
		System.out.println();
		traverse(bTree.root);

	}

	public static BinaryTree createTree() {

		BinaryTree binaryTree = new BinaryTree();
		binaryTree.root = new TreeNode(2);
		binaryTree.root.left = new TreeNode(4);
		binaryTree.root.right = new TreeNode(1);
		binaryTree.root.left.left = new TreeNode(6);
		binaryTree.root.left.right = new TreeNode(9);
		binaryTree.root.right.right = new TreeNode(2);
		binaryTree.root.left.right.left = new TreeNode(3);

		return binaryTree;
	}

	public static void addChildSum(TreeNode root) {
		if (root == null) {
			return;
		}

		// compute for left subtree.
		addChildSum(root.left);

		// compute for right subtree.
		addChildSum(root.right);

		int finalSum = root.value;
		if (root.left != null) {
			finalSum += root.left.value;
		}

		if (root.right != null) {
			finalSum += root.right.value;
		}

		root.value = finalSum;
	}

	// traverse tree in postorder
	public static void traverse(TreeNode root) {
		if (root != null) {
			traverse(root.left);
			traverse(root.right);
			System.out.print(root.value + ",");
		}
	}
	
}

class TreeNode {
	public TreeNode(int item) {
		left = right = null;
		value = item;
	}

	TreeNode left, right;
	int value;
	
	public boolean isLeaf() {
		if(this.left == null && this.right == null) {
			return true;
		}
		return false;
	}
}

class BinaryTree {
	// root of the binary tree;
	TreeNode root;

	public BinaryTree() {
		root = null;
	}

}
