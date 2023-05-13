package com.practice.problems.leetcode.binarytree;

import java.util.*;

public class Problem863$AllNodesAtDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentNodesMap = new HashMap<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if(curr.left != null) {
                    queue.offer(curr.left);
                    parentNodesMap.put(curr.left, curr);
                }

                if(curr.right != null) {
                    queue.offer(curr.right);
                    parentNodesMap.put(curr.right, curr);
                }
            }
        }

        int currDistance = 0;
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        queue = new LinkedList<>();
        queue.offer(target);

        while (!queue.isEmpty()) {
            int size = queue.size();
            if(currDistance == k) {
                break;
            }

            currDistance++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if(curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                    visited.add(curr.right);
                }
                if(parentNodesMap.get(curr) != null && !visited.contains(parentNodesMap.get(curr))) {
                    queue.offer(parentNodesMap.get(curr));
                    visited.add(parentNodesMap.get(curr));
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
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

        Problem863$AllNodesAtDistanceKInBinaryTree obj = new Problem863$AllNodesAtDistanceKInBinaryTree();
        obj.distanceK(root, new TreeNode(3), 2).forEach(num -> System.out.print(num + " "));
    }
}
