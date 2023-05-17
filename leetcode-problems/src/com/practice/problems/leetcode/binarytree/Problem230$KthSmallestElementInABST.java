package com.practice.problems.leetcode.binarytree;

public class Problem230$KthSmallestElementInABST {

    public int kthSmallest(TreeNode root, int k) {
        TreeNode res = kthSmallestNode(root, new int[]{k});
        if (res == null) return -1;
        else return res.val;

    }

    public TreeNode kthSmallestNode(TreeNode root, int[] k) {
        if (root == null) return null;

        TreeNode left = kthSmallestNode(root.left, k);
        if (left != null) {
            return left;
        }
        k[0]--;
        if (k[0] == 0) {
            return root;
        }

        return kthSmallestNode(root.right, k);
    }

    /*public int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);

        if(k > inOrderList.size()) return -1;
        return inOrderList.get(k - 1);
    }

    private void inOrder(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }
        inOrder(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right, inOrderList);
    }*/

    /*public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        if(stack.size() >= k) {
            int n = 0;
            TreeNode poppedElement = stack.peek();
            while(n < k) {
                poppedElement = stack.pop();
                n++;
            }
            return poppedElement.val;
        }

        int n = 0;
        Set<TreeNode> visited = new HashSet<>();
        TreeNode poppedElement = stack.peek();
        while(n < k) {
            poppedElement = stack.pop();
            visited.add(poppedElement);
            if(poppedElement.left != null && !visited.contains(poppedElement)) {
                stack.push(poppedElement.left);
            }
            if(poppedElement.right != null && !visited.contains(poppedElement)) {
                stack.push(poppedElement.right);
            }
            n++;
        }
        return poppedElement.val;

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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Problem230$KthSmallestElementInABST obj = new Problem230$KthSmallestElementInABST();
        System.out.println(obj.kthSmallest(root, 3));//Expected Ans: 3

    }
}
