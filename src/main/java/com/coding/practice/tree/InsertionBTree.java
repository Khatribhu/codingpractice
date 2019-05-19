package com.coding.practice.tree;

public class InsertionBTree {

	public void insertElement(TreeNode root, int element) {
		if(root == null) {
			return;
		}
		
		insertElement(root.left, element);
		
		insertElement(root.right,element);
	}
}
