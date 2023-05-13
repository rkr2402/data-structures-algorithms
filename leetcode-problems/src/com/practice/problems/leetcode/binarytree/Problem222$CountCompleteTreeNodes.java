package com.practice.problems.leetcode.binarytree;

public class Problem222$CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = calculateLeftHeight(root);
        int rightHeight = calculateRightHeight(root);

        if (leftHeight == rightHeight) return ((2 << leftHeight) - 1);
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int calculateRightHeight(TreeNode node) {
        int height = 0;

        while (node.left != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int calculateLeftHeight(TreeNode node) {
        int height = 0;

        while (node.right != null) {
            height++;
            node = node.right;
        }
        return height;
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        Problem222$CountCompleteTreeNodes obj = new Problem222$CountCompleteTreeNodes();
        System.out.println(obj.countNodes(root));
    }
}
