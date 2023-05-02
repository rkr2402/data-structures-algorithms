package com.practice.ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS$LevelWiseTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return resultList;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int nodes = queue.size();
            List<Integer> levelOrderNums = new LinkedList<>();

            for (int i = 0; i < nodes; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) continue;
                levelOrderNums.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            resultList.add(levelOrderNums);
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BFS$LevelWiseTraversal obj = new BFS$LevelWiseTraversal();
        obj.levelOrder(root).forEach(list -> list.forEach(num -> System.out.print(num + " ")));
    }


    //      Definition for a binary tree node.
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
}
