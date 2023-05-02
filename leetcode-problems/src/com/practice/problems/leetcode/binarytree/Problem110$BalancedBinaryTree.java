package com.practice.problems.leetcode.binarytree;

public class Problem110$BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = dfsHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
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

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        Problem110$BalancedBinaryTree obj = new Problem110$BalancedBinaryTree();
        System.out.println(obj.isBalanced(root1));
        System.out.println(obj.isBalanced(root2));
    }
}
