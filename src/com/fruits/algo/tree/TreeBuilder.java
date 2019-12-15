package com.fruits.algo.tree;

public class TreeBuilder {
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

	public static void printTree(TreeNode root) {
		System.out.println(root.getData());
		if (null != root.getLeftChild())
			printTree(root.getLeftChild());
		if (null != root.getRightChild())
			printTree(root.getRightChild());
	}

	public static void printTreeByPreorder(TreeNode root) {
		if(root == null)
			return;
		System.out.println(root.getData());

		printTreeByPreorder(root.getLeftChild());
		printTreeByPreorder(root.getRightChild());
	}

	public static void printTreeByInorder(TreeNode root) {
		if(root == null)
			return;

		printTreeByInorder(root.getLeftChild());
		System.out.println(root.getData());
		printTreeByInorder(root.getRightChild());
	}

	public static void printTreeByPostorder(TreeNode root) {
		if(root == null)
			return;

		printTreeByPostorder(root.getLeftChild());
		printTreeByPostorder(root.getRightChild());
		System.out.println(root.getData());
	}

	public static void printTreeByLevelorder(TreeNode root) {

	}

	public static void main(String[] args) {
		//printTreeByPostorder(build(new char[]{'A','B','D','E','C','F','G'},0, new char[]{'D','B','E','A','C','G','F'},0,7));
		printTreeByPostorder(build(new char[]{'A','B','D','E','C','F','G'},0, new char[]{'D','B','E','A','C','F','G'},0,7));
	}
}
