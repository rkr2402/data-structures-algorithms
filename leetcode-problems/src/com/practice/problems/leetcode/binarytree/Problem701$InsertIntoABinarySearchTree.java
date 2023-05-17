package com.practice.problems.leetcode.binarytree;

public class Problem701$InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode current = root;
        TreeNode parent;

        while (true) {
            parent = current;
            if(current.val > val) {
                current = current.left;
                if(current == null) {
                    parent.left = new TreeNode(val);
                    break;
                }
            } else {
                current = current.right;
                if(current == null) {
                    parent.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
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
        Problem701$InsertIntoABinarySearchTree obj = new Problem701$InsertIntoABinarySearchTree();
    }
}
