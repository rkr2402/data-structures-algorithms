package com.practice.problems.leetcode.binarytree;

public class Problem98$ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBSTAndBwMinMax(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTAndBwMinMax(TreeNode node, long minValue, long maxValue) {
        if (node == null)
            return true;

        if (node.val >= maxValue || node.val <= minValue) {
            return false;
        }
        boolean isLeftBSTValid = isValidBSTAndBwMinMax(node.left, minValue, node.val);
        boolean isRightBSTValid = isValidBSTAndBwMinMax(node.right, node.val, maxValue);

        return isLeftBSTValid && isRightBSTValid;
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Problem98$ValidateBinarySearchTree obj = new Problem98$ValidateBinarySearchTree();
        System.out.println(obj.isValidBST(root));
    }
}
