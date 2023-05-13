package com.practice.problems.leetcode.binarytree;

public class Problem101$SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return inOrderTraversal(root.left, root.right);
    }

    private boolean inOrderTraversal(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }

        return inOrderTraversal(left.left, right.right) && inOrderTraversal(left.right, right.left);
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
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(3);

        Problem101$SymmetricTree obj = new Problem101$SymmetricTree();
        System.out.println(obj.isSymmetric(root1));
        System.out.println(obj.isSymmetric(root2));
    }
}
