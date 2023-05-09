package com.practice.problems.leetcode.binarytree;

import java.util.*;

public class TopViewofBinaryTree {

    public ArrayList<Integer> getTopView(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            if (!map.containsKey(curr.x)) map.put(curr.x, curr.node.val);

            if (curr.node.left != null) {
                queue.offer(new Pair(curr.x - 1, curr.node.left));
            }

            if (curr.node.right != null) {
                queue.offer(new Pair(curr.x + 1, curr.node.right));
            }
        }

        return new ArrayList<>(map.values());
    }

    private static class Pair {
        int x;
        TreeNode node;

        public Pair(int _x, TreeNode _node) {
            this.x = _x;
            this.node = _node;
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
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.left.left.right.left = new TreeNode(9);
        root.left.left.right.left.left = new TreeNode(10);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(8);
        root.right.right.left.right = new TreeNode(11);

        TopViewofBinaryTree obj = new TopViewofBinaryTree();
        obj.getTopView(root).forEach(num -> System.out.print(num + " "));//expected: 10, 4, 2, 1, 3, 6
    }
}
