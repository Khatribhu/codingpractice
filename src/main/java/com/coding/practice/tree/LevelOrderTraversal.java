package com.coding.practice.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

	public void printLevelOrderTraversal(TreeNode root, PriorityQueue<Integer> queue) {
		if (root == null) {
			return;
		}
		queue.add(root.value);
		if (root.left != null) {
			queue.add(root.left.value);
		}

		if (root.right != null) {
			queue.add(root.right.value);
		}

		printLevelOrderTraversal(root.left, queue);
		printLevelOrderTraversal(root.right, queue);
	}

	public TreeNode insert(TreeNode root, int data) {
		if (root == null) {
			return new TreeNode(data);
		} else {
			TreeNode cur;
			if (data <= root.value) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	void levelOrder(TreeNode root){
	    Queue<TreeNode> queue = new LinkedList<>(); 
	    queue.add(root);

	    while(queue.size() > 0) {
	    	TreeNode temp = queue.poll();
	        System.out.println(temp.value);
	        if(temp.left != null) {
	          queue.add(temp.left);
	        }
	        if(temp.right != null) {
	          queue.add(temp.right);
	        }
	    }
	}
	
	public static void main(String args[]) {
		LevelOrderTraversal obj = new LevelOrderTraversal();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		TreeNode root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = obj.insert(root, data);
		}
		obj.levelOrder(root);
	}

}
