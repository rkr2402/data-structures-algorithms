package com.practice.problems.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversalofBinaryTree {

    public ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        if (!isLeafNode(root)) ans.add(root.val);
        //traverse left
        addLeftBoundary(root, ans);
        //read leaves nodes
        addLeaves(root, ans);
        //traverse right
        addRightBoundary(root, ans);
        return ans;
    }

    private void addRightBoundary(TreeNode root, ArrayList<Integer> ans) {
        Stack<Integer> stack = new Stack<>();
        TreeNode curr = root.right;
        while (curr != null) {
            if (!isLeafNode(curr)) stack.push(curr.val);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
    }

    private void addLeaves(TreeNode node, ArrayList<Integer> ans) {
        if (isLeafNode(node)) {
            ans.add(node.val);
            return;
        }

        if (node.left != null) addLeaves(node.left, ans);
        if (node.right != null) addLeaves(node.right, ans);
    }

    private void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeafNode(curr)) ans.add(curr.val);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private boolean isLeafNode(TreeNode node) {
        return (node.left == null && node.right == null);
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
        root.right.right = new TreeNode(7);

        BoundaryTraversalofBinaryTree obj = new BoundaryTraversalofBinaryTree();
        obj.traverseBoundary(root).forEach(num -> System.out.print(num + " "));
    }
}
