package com.practice.problems.leetcode.binarytree;

import java.util.*;

public class Problem987$VerticalOrderTraversalOfBinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        dfs(0, 0, root, map);
        for (TreeMap<Integer, PriorityQueue<Integer>> curr : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> pq : curr.values()) {

                while (!pq.isEmpty()) {
                    res.get(res.size() - 1).add(pq.poll());
                }
            }
        }

        return res;
    }

    private void dfs(int x, int y, TreeNode node, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }

        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }

        map.get(x).get(y).offer(node.val);

        dfs(x - 1, y + 1, node.left, map);
        dfs(x + 1, y + 1, node.right, map);
    }

    /*public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<TreeNode, PointXY> pointsMap = new HashMap<>();
        dfs(0, 0, root, pointsMap);

        List<Map.Entry<TreeNode, PointXY>> list =
                pointsMap.entrySet().stream().sorted((entry1, entry2) -> {
                                    if (entry1.getValue().x > entry2.getValue().x) return 1;
                                    else if (entry1.getValue().x < entry2.getValue().x) return -1;
                                    else {
                                        if (entry1.getValue().y > entry2.getValue().y) return -1;
                                        else if (entry1.getValue().y < entry2.getValue().y) return 1;
                                        else return (entry1.getKey().val - entry2.getKey().val);
                                    }
                                }
                        )
                        *//*  .forEach(entry -> {
                      System.out.println("key: " + entry.getKey().val + ", value: x=" + entry.getValue().x + ",y=" + entry.getValue().y);
                  });*//*
                        .collect(Collectors.toList());

        int currX = list.get(0).getValue().x;
        int currY = list.get(0).getValue().y;
        List<Integer> currList = new ArrayList<>();

        for (Map.Entry<TreeNode, PointXY> treeNodePointXYEntry : list) {
            if (currX == treeNodePointXYEntry.getValue().x) {
                currList.add(treeNodePointXYEntry.getKey().val);
            } else {
                currX = treeNodePointXYEntry.getValue().x;
                ans.add(currList);
                currList = new ArrayList<>();
                currList.add(treeNodePointXYEntry.getKey().val);
            }
        }

        ans.add(currList);

        *//*for (Map.Entry<TreeNode, PointXY> entry : pointsMap.entrySet()) {
            System.out.println("key: " + entry.getKey().val + ", value: x=" + entry.getValue().x + ",y=" + entry.getValue().y);
        }*//*
        return ans;
    }*/

    public void dfs(int x, int y, TreeNode node, Map<TreeNode, PointXY> pointsMap) {
        if (node == null) {

            return;
        }

        dfs(x - 1, y - 1, node.left, pointsMap);
        pointsMap.put(node, new PointXY(x, y));
        dfs(x + 1, y + 1, node.right, pointsMap);
    }

    private static class PointXY {
        int x;
        int y;

        public PointXY(int x1, int y1) {
            this.x = x1;
            this.y = y1;
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

        Problem987$VerticalOrderTraversalOfBinaryTree obj = new Problem987$VerticalOrderTraversalOfBinaryTree();
        obj.verticalTraversal(root).forEach(list -> {
            list.forEach(num -> System.out.print(num + " "));
            System.out.println();
        });
    }
}
