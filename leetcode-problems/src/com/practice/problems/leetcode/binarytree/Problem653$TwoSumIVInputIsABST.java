package com.practice.problems.leetcode.binarytree;

import java.util.HashSet;
import java.util.Set;

public class Problem653$TwoSumIVInputIsABST {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, k , set);
    }

    private boolean dfs(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }

        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k , set);
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(7);
        
        Problem653$TwoSumIVInputIsABST obj = new Problem653$TwoSumIVInputIsABST();
        System.out.println(obj.findTarget(root, 9));
    }
}
