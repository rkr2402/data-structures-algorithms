package com.practice.problems.leetcode.binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class Problem297$SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        StringBuilder encodedString = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
//        encodedString.append(root.val).append(" ");

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) {
                encodedString.append("n ");
                continue;
            }
            encodedString.append(curr.val).append(" ");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return encodedString.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 0; i < nodes.length; i++) {
            TreeNode curr = queue.poll();
            if(!nodes[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = left;
                queue.offer(left);
            }
            if(!nodes[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = right;
                queue.offer(right);
            }
        }

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
        Problem297$SerializeAndDeserializeBinaryTree obj;
    }
}
