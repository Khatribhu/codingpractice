package src.java.practice.tree;

public class PrintAllLeafNodes {

	public static void main(String[] args) {
		
	}
	
	public static void printLeaf(TreeNode node) {
		if(node == null) {
			return;
		}
		
		if(node.isLeaf()) {
			System.out.println(node.value);
		}
		
		if(node.left != null) {
			printLeaf(node.left);
		}
		
		if(node.right != null) {
			printLeaf(node.right);
		}
	
	}
 }
