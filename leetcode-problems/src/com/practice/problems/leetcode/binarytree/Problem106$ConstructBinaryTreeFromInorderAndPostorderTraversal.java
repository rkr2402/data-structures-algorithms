package com.practice.problems.leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

public class Problem106$ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderNumsIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderNumsIndexMap.put(inorder[i], i);
        }

        return resolve(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inOrderNumsIndexMap);

    }

    private TreeNode resolve(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd, Map<Integer, Integer> inOrderNumsIndexMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inOrderRootIndex = inOrderNumsIndexMap.get(root.val);
        int numsLeft = inOrderRootIndex - inStart;

        root.left = resolve(inOrder, inStart, inOrderRootIndex - 1, postOrder, postStart, postStart + numsLeft - 1, inOrderNumsIndexMap);
        root.right = resolve(inOrder, inOrderRootIndex + 1, inEnd, postOrder, postStart + numsLeft, postEnd - 1, inOrderNumsIndexMap);

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
        Problem106$ConstructBinaryTreeFromInorderAndPostorderTraversal obj = new Problem106$ConstructBinaryTreeFromInorderAndPostorderTraversal();

    }
}
