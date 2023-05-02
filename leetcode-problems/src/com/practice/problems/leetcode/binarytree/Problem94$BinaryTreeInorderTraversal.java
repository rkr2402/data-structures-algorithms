package com.practice.problems.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem94$BinaryTreeInorderTraversal {

    //OPTIMAL SOLUTION
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) { //go left
                stack.push(node);
                node = node.left;
            } else { //traverse current and go right
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }

        return result;
    }

    /**
     * My Solution, ran fine on leetcode and got submitted too
     */
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.left == null && curr.right == null) {
                result.add(curr.val);
                continue;
            }

            if (curr.right != null) stack.push(curr.right);
            stack.push(new TreeNode(curr.val));
            if (curr.left != null) stack.push(curr.left);

        }

        return result;
    }*/

    //      Definition for a binary tree node.
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

        Problem94$BinaryTreeInorderTraversal obj = new Problem94$BinaryTreeInorderTraversal();
        obj.inorderTraversal(root).forEach(num -> System.out.print(num + " "));
    }
}
