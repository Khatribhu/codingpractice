package com.coding.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author bkhatri3
 *
 */
public class LCABTree {
	TreeNode root;
	static List<TreeNode> path1 = new ArrayList<>();
	static List<TreeNode> path2 = new ArrayList<>();

	public static void main(String[] args) {
		LCABTree tree = new LCABTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);

		System.out.println("LCA(4, 5): " + tree.findLCAOneTraversal(tree.root, 4, 5).value);
		System.out.println("LCA(4, 6): " + tree.findLCA(4, 6));
		System.out.println("LCA(3, 4): " + tree.findLCA(3, 4));
		System.out.println("LCA(2, 4): " + tree.findLCA(2, 4));
	}

	/**
	 * 
	 * time complexity: O(n) tree is traversed twice.
	 */
	public int printLCAInternal(TreeNode treeNode, int n1, int n2) {
		if (!findPath(root, n1, path1) || !findPath(treeNode, n2, path2)) {
			if (path1.size() > 0)
				System.out.println("n1 is present, n2 is not");
			if (path2.size() > 0)
				System.out.println("n2 is present n1 is not");
		}

		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
			if (!path1.get(i).equals(path2.get(i))) {
				break;
			}
		}

		// System.out.println();
		return path1.get(i - 1).value;
	}

	public int findLCA(int n1, int n2) {
		path1.clear();
		path2.clear();
		return printLCAInternal(root, n1, n2);
	}

	public static boolean findPath(TreeNode root, int n, List<TreeNode> path) {
		if (root == null) {
			return false;
		}
		path.add(root);
		if (root.value == n) {
			return true;
		}
		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}
		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

	// using single traversal.
	public TreeNode findLCAOneTraversal(TreeNode node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		if (node.value == n1 || node.value == n2) {
			return node;
		}

		TreeNode left = findLCAOneTraversal(node.left, n1, n2);
		TreeNode right = findLCAOneTraversal(node.right, n1, n2);

		if (left != null && right != null) {
			return node;
		}

		return left != null ? left : right;

	}

}