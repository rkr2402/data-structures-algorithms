package com.practice.problems.leetcode.binarytree;

import java.util.*;

public class BottomViewOfBinaryTree {

    public ArrayList<Integer> bottomView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        if (root == null) return new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            map.put(curr.line, curr.node.val);

            if (curr.node.left != null) queue.offer(new Pair(curr.node.left, curr.line - 1));
            if (curr.node.right != null) queue.offer(new Pair(curr.node.right, curr.line + 1));
        }
        return new ArrayList<>(map.values());
    }

    private static class Pair {
        TreeNode node;
        int line;

        public Pair(TreeNode _node, int _y) {
            this.node = _node;
            this.line = _y;
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
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(6);
        root1.right.left.left = new TreeNode(7);
        root1.right.left.right = new TreeNode(8);

        BottomViewOfBinaryTree obj = new BottomViewOfBinaryTree();
        obj.bottomView(root).forEach(num -> System.out.print(num + " "));
        System.out.println();
        obj.bottomView(root1).forEach(num -> System.out.print(num + " "));
    }
}
