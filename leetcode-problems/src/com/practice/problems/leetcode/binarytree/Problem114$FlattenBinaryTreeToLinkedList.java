package com.practice.problems.leetcode.binarytree;

public class Problem114$FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        TreeNode curr = root;

        TreeNode prev = null;
        while (curr != null) {
            if (curr.left != null) {
                prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
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
        Problem114$FlattenBinaryTreeToLinkedList obj = new Problem114$FlattenBinaryTreeToLinkedList();
    }
}
