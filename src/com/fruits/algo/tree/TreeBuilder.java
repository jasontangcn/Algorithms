package com.fruits.algo.tree;

public class TreeBuilder {
	public static TreeNode build(char[] preOrder, int i, char[] midOrder, int j, int n) {
		if (n <= 0)
			return null;

		TreeNode node = new TreeNode();
		node.setData(preOrder[i]);

		int k;
		for (k = j; k < n; k++) {
			if (midOrder[k] == preOrder[i])
				break;
		}

		node.setLeftChild(build(preOrder, i + 1, midOrder, j, k - j));
		node.setRightChild(build(preOrder, i + k - j + 1, midOrder, k + 1, n - (k - j) - 1));

		return node;
	}

	public static void printTree(TreeNode root) {
		System.out.println(root.getData());
		if (null != root.getLeftChild())
			printTree(root.getLeftChild());
		if (null != root.getRightChild())
			printTree(root.getRightChild());
	}

	public static void main(String[] args) {
		printTree(build(new char[]{'A','B','D','E','C','F','G'},0, new char[]{'D','B','E','A','C','G','F'},0,7));
	}
}
