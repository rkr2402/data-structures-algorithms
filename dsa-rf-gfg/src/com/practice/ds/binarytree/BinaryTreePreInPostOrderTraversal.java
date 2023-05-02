package com.practice.ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreInPostOrderTraversal {

    public void preInPostorderTraversal(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null)
            return;

        while (!stack.isEmpty()) {
            Pair curr = stack.pop();

            //this is part of pre, increment 1 to 2, push the left side of the tree
            if (curr.count == 1) {
                pre.add(curr.node.val);
                curr.count++;
                stack.push(curr);

                if (curr.node.left != null) {
                    stack.push(new Pair(curr.node.left, 1));
                }
            }
            //this is part of in, increment 1 to 2, push to the right side of the tree
            else if (curr.count == 2) {
                in.add(curr.node.val);
                curr.count++;
                stack.push(curr);

                if (curr.node.right != null) {
                    stack.push(new Pair(curr.node.right, 1));
                }
            }
            //dont push it back again
            else {
                post.add(curr.node.val);
            }
        }
    }

    private static class Pair {
        TreeNode node;
        int count;

        Pair(TreeNode tn, int cnt) {
            this.node = tn;
            this.count = cnt;
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
            BinaryTreePreInPostOrderTraversal obj = new BinaryTreePreInPostOrderTraversal();
        }

}
