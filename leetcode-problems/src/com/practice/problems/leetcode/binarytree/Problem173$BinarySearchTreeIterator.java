package com.practice.problems.leetcode.binarytree;

import java.util.Stack;

public class Problem173$BinarySearchTreeIterator {

    class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        private void pushAll(TreeNode node) {
            TreeNode left = node;
            while (left != null) {
                stack.push(left);
                left = left.left;
            }
        }

        public int next() {
            TreeNode next = stack.pop();
            pushAll(next.right);
            return next.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
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
        Problem173$BinarySearchTreeIterator obj = new Problem173$BinarySearchTreeIterator();

    }
}
