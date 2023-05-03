package com.practice.problems.leetcode.binarytree;

public class Problem124$BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] maxPath = new int[]{Integer.MIN_VALUE};
        dfsPath(root, maxPath);
        return maxPath[0];
    }

    private int dfsPath(TreeNode node, int[] maxPathSum) {
        if (node == null) {
            return 0;
        }

        int leftTreePath = Math.max(0, dfsPath(node.left, maxPathSum));
        int rightTreePath = Math.max(0, dfsPath(node.right, maxPathSum));

        maxPathSum[0] = Math.max(maxPathSum[0], leftTreePath + rightTreePath + node.val);
        return node.val + Math.max(leftTreePath, rightTreePath);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.left.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(4);


    }
}
