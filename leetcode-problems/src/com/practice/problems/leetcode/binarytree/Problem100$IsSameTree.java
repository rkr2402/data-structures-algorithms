package com.practice.problems.leetcode.binarytree;

public class Problem100$IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean isLeftTreeSame = isSameTree(p.left, q.left);
        boolean isRightTreeSame = isSameTree(p.right, q.right);

        return isLeftTreeSame && isRightTreeSame;
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
}
