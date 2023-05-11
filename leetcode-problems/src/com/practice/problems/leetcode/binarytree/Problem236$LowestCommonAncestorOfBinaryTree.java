package com.practice.problems.leetcode.binarytree;

public class Problem236$LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }

        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return node;
        }
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
        TreeNode p = new TreeNode(4);
        root.left.left = p;
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        TreeNode q = new TreeNode(7);
        root.left.right.right = q;
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        Problem236$LowestCommonAncestorOfBinaryTree obj = new Problem236$LowestCommonAncestorOfBinaryTree();
        System.out.println(obj.lowestCommonAncestor(root, p, q).val);
    }
}
