package com.fruits.algo.tree;

public class TreeUtils {
	public static TreeNode build(char[] preorder, int i, char[] inorder, int j, int n) {
		if (n <= 0)
			return null;

		TreeNode node = new TreeNode();
		node.setData(preorder[i]);

		int k;
		for (k = j; k < n; k++) {
			if (inorder[k] == preorder[i])
				break;
		}

		node.setLeftChild(build(preorder, i + 1, inorder, j, k - j));
		node.setRightChild(build(preorder, i + k - j + 1, inorder, k + 1, n - (k - j) - 1));

		return node;
	}

	public static void printTree(TreeNode node) {
		System.out.println(node.getData());
		if (null != node.getLeftChild())
			printTree(node.getLeftChild());
		if (null != node.getRightChild())
			printTree(node.getRightChild());
	}

	public static void printTreeByPreorder(TreeNode node) {
		if(node == null)
			return;
		System.out.println(node.getData());

		printTreeByPreorder(node.getLeftChild());
		printTreeByPreorder(node.getRightChild());
	}

	public static void printTreeByInorder(TreeNode node) {
		if(node == null)
			return;

		printTreeByInorder(node.getLeftChild());
		System.out.println(node.getData());
		printTreeByInorder(node.getRightChild());
	}

	public static void printTreeByPostorder(TreeNode node) {
		if(node == null)
			return;

		printTreeByPostorder(node.getLeftChild());
		printTreeByPostorder(node.getRightChild());
		System.out.println(node.getData());
	}

	public static void printTreeByLevelorder(TreeNode node) {

	}

	public static void main(String[] args) {
		//printTreeByPostorder(build(new char[]{'A','B','D','E','C','F','G'},0, new char[]{'D','B','E','A','C','G','F'},0,7));
		printTreeByPostorder(build(new char[]{'A','B','D','E','C','F','G'},0, new char[]{'D','B','E','A','C','F','G'},0,7));
	}
}
