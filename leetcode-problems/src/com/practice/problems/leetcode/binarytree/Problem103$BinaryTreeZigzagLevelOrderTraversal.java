package com.practice.problems.leetcode.binarytree;

import java.util.*;
import java.util.stream.Collectors;

public class Problem103$BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = true;

        while (!queue.isEmpty()) {
            int noOfLevelNodes = queue.size();
            System.out.println("noOfLevelNodes: " + noOfLevelNodes);
            Integer[] row = new Integer[noOfLevelNodes];

            for (int i = 0; i < noOfLevelNodes; i++) {
                TreeNode curr = queue.remove();
                int index = isLeft ? i : noOfLevelNodes - 1 - i;
                row[index] = curr.val;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);


            }
            isLeft = !isLeft;
            ans.add(Arrays.stream(row).collect(Collectors.toList()));
        }
        return ans;
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

        Problem103$BinaryTreeZigzagLevelOrderTraversal obj = new Problem103$BinaryTreeZigzagLevelOrderTraversal();
        obj.zigzagLevelOrder(root).forEach(list -> list.forEach(num -> System.out.print(num + " ")));
    }
}
