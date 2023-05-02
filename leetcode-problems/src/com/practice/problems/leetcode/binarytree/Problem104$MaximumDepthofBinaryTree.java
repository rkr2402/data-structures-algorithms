package com.practice.problems.leetcode.binarytree;

public class Problem104$MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        //base case
        if(root == null) {
            return 0;
        }

        //recursive case
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
        
        Problem104$MaximumDepthofBinaryTree obj = new Problem104$MaximumDepthofBinaryTree();
        System.out.println(obj.maxDepth(root));
    }
}
