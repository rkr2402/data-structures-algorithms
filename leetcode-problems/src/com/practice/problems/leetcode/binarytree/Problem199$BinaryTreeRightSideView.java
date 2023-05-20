package com.practice.problems.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Problem199$BinaryTreeRightSideView {
    //Optimized Approach
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(0, root, result);
        return result;
    }

    private void dfs(int depth, TreeNode node, List<Integer> rightViewNodes) {
        if (node == null) {
            return;
        }

        if (depth == rightViewNodes.size()) {
            rightViewNodes.add(node.val);
        }
        //traverse right node first as we need right view
        dfs(depth + 1, node.right, rightViewNodes);
        dfs(depth + 1, node.left, rightViewNodes);
    }

    /*public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        queue.offer(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if(!map.containsKey(curr.x)) map.put(curr.x, curr.node.val);

            if(curr.node.right != null) {
                queue.offer(new Pair(curr.x - 1, curr.node.right));
            }

            if(curr.node.left != null) {
                queue.offer(new Pair(curr.x - 1, curr.node.left));
            }
        }

        res = new ArrayList<>(map.values());
        return res;
    }

    private static class Pair {
        int x;
        TreeNode node;

        public Pair(int _x, TreeNode _node) {
            this.x = _x;
            this.node = _node;
        }
    }*/

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


        Problem199$BinaryTreeRightSideView obj = new Problem199$BinaryTreeRightSideView();
        obj.rightSideView(root).forEach(num -> System.out.print(num + " "));
    }
}
