package com.practice.problems.leetcode.binarytree;

public class Problem235$LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p , q);
        }

        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p , q);
        }
        return null;
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
        TreeNode root = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        root.left = p;
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        TreeNode q = new TreeNode(4);
        root.left.right = q;
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        Problem235$LowestCommonAncestorOfABinarySearchTree obj = new Problem235$LowestCommonAncestorOfABinarySearchTree();
        System.out.println(obj.lowestCommonAncestor(root, p , q).val);
    }
}
