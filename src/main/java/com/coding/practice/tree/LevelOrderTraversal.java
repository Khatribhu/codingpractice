package com.coding.practice.tree;

import java.util.PriorityQueue;

public class LevelOrderTraversal {

	public void printLevelOrderTraversal(TreeNode root, PriorityQueue<Integer> queue) {
		if(root == null) {
			return;
		}
		queue.add(root.value);
		if(root.left != null) {
			queue.add(root.left.value);
		}
		
		if(root.right != null) {
			queue.add(root.right.value);
		}
		
		printLevelOrderTraversal(root.left, queue);
		printLevelOrderTraversal(root.right, queue);
	}
	
}
