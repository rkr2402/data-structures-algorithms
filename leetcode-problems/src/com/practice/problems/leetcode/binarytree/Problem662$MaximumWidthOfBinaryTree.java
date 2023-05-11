package com.practice.problems.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem662$MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        int result = 0;

        if (root == null) return result;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int nodes = queue.size();
            int minIndex = queue.peek().index;
            int start = 0;
            int end = 0;
            for (int i = 0; i < nodes; i++) {
                Pair curr = queue.poll();
                int idx = curr.index - minIndex;
                if (i == 0) start = idx;
                if (i == nodes - 1) end = idx;
                if (curr.node.left != null) queue.offer(new Pair(curr.node.left, (2 * idx + 1)));
                if (curr.node.right != null) queue.offer(new Pair(curr.node.right, (2 * idx + 2)));
            }

            result = Math.max(result, end - start + 1);
        }

        return result;
    }

    private static class Pair {
        private TreeNode node;
        private int index;

        public Pair(TreeNode _node, int _index) {
            this.node = _node;
            this.index = _index;
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode p = new TreeNode(4);
        root.left.left = p;
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        TreeNode q = new TreeNode(7);
        root.left.right.right = q;
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        Problem662$MaximumWidthOfBinaryTree obj = new Problem662$MaximumWidthOfBinaryTree();
        System.out.println(obj.widthOfBinaryTree(root));
        ;
    }
}
