package com.practice.problems.leetcode.binarytree;

public class Problem543$DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        dfsHeight(root, diameter);
        return diameter[0];
    }

    private int dfsHeight(TreeNode node, int[] diameter) {
        if (node == null)
            return 0;

        int leftTreeHeight = dfsHeight(node.left, diameter);
        int rightTreeHeight = dfsHeight(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftTreeHeight + rightTreeHeight);
        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
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
        Problem543$DiameterOfBinaryTree obj = new Problem543$DiameterOfBinaryTree();

    }
}
