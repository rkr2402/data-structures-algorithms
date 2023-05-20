package com.practice.problems.leetcode.binarytree;

public class Problem1008$ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return createBST(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    private TreeNode createBST(int[] preorder, int[] index, int upperBound) {
        if (index[0] == preorder.length || preorder[index[0]] > upperBound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = createBST(preorder, index, root.val);
        root.right = createBST(preorder, index, upperBound);
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
        Problem1008$ConstructBinarySearchTreeFromPreorderTraversal obj =
                new Problem1008$ConstructBinarySearchTreeFromPreorderTraversal();
    }
}
