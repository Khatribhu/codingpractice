package src.java.practice.tree;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DirectoryDeletion {

	public DirectoryNode root;

	public static class DirectoryNode {
		int val;
		DirectoryNode left;
		DirectoryNode right;

		public DirectoryNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

	public static int[] findIndexes(int[] arr, int val) {
		int[] result = new int[2];
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == val) {
				result[j++] = i + 1;
			}
		}
		return result;
	}

	public void createTree(int[] arr) {
		this.root = new DirectoryNode(1);
		addNode(arr, this.root);
	}

	public void addNode(int[] arr, DirectoryNode node) {
		if (node == null) {
			return;
		}
		int[] temp = new int[2];
		temp = findIndexes(arr, node.val);
		if (temp.length == 0) {
			return;
		}
		if (temp.length > 1) {
			if(temp[0] != 0) {
				node.left = new DirectoryNode(temp[0]);
			}
			
			if(temp[1] != 0) {
				node.right = new DirectoryNode(temp[1]);
			}
		}
		addNode(arr, node.left);
		addNode(arr, node.right);
	}
	
	public int delete(DirectoryNode node, int count, Set<Integer> set) {
		if(node == null) {
			return count;
		}
		
		if(node.left != null && set.contains(node.left.val)) {
			node.left = null;
			count++;
		}
		
		if(node.right != null && set.contains(node.right.val)) {
			node.right = null;
			count++;
		}
		
		delete(node.left, count, set);
		delete(node.right, count, set);
		return count;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int val = scn.nextInt();
		int[] arr = new int[val];
		for(int i = 0; i < val; i++) {
			arr[i] = scn.nextInt();
		}	
		
		int count = scn.nextInt();
		Set<Integer> set = new HashSet<>();
		for(int j = 0; j < count; j++) {
			set.add(scn.nextInt());
		}
		DirectoryDeletion newObject = new DirectoryDeletion();
		newObject.createTree(arr);
		
		System.out.println(newObject.delete(newObject.root, 0, set));
	}
}
