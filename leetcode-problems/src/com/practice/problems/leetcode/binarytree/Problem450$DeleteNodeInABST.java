package com.practice.problems.leetcode.binarytree;

public class Problem450$DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.val != key) {
            parent = current;
            if(key < current.val) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if(current == null) {
                return root; // node to be deleted not found
            }
        }

        //found node to be deleted
        //Case 1: Node to deleted is a leaf node
        if(current.left == null && current.right == null) {
            if(current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        //Case 2: Node to be deleted has only one leaf node
        else if(current.right == null) {
            if(root == current) {
                root = current.left;
            }
            else if(isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if(current.left == null) {
            if(root == current) {
                root = current.right;
            }
            else if(isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        //Case 3: Node to be deleted has 2 children
        else {
            //Case 3: Node to be deleted has 2 children
            TreeNode successor = getSuccessor(current);
            //connect parent of current to successor
            if(current == root) {
                root = successor;
            }
            else if(isLeftChild) {
                parent.left = successor;
            }
            else {
                parent.right = successor;
            }
            //connect successor to current's left
            successor.left = current.left;
        }
        //successor cannot have a left child

        return root;
    }

    private TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successorParent = delNode;
        TreeNode successor = delNode;
        TreeNode current = delNode.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if(successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }

        return successor;
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
        Problem450$DeleteNodeInABST obj = new Problem450$DeleteNodeInABST();
    }
}
