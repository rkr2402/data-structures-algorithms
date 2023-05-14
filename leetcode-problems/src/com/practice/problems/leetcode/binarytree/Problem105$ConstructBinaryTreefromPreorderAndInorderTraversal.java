package com.practice.problems.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class Problem105$ConstructBinaryTreefromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderValuesIndexMap = new HashMap<>();//store value and its index map
        for (int i = 0; i < inorder.length; i++) {
            inOrderValuesIndexMap.put(inorder[i], i);
        }

        return reSolve(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderValuesIndexMap);
    }

    private TreeNode reSolve(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inOrderValuesIndexMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIndex = inOrderValuesIndexMap.get(root.val);
        int numsLeft = inRootIndex - inStart;

        root.left = reSolve(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRootIndex - 1, inOrderValuesIndexMap);
        root.right = reSolve(preorder, preStart + numsLeft + 1, preEnd, inorder, inRootIndex + 1, inEnd, inOrderValuesIndexMap);
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
        Problem105$ConstructBinaryTreefromPreorderAndInorderTraversal obj = new Problem105$ConstructBinaryTreefromPreorderAndInorderTraversal();
        TreeNode root = obj.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

    }

}
