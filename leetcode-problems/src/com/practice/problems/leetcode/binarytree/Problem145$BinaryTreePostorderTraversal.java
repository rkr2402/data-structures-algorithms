package com.practice.problems.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem145$BinaryTreePostorderTraversal {

    //Using 1 stack
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode temp = null;

        while (curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.peek();
                    postorder.add(temp.val);
                    stack.pop();

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.peek();
                        stack.pop();
                        postorder.add(temp.val);
                    }
                } else {
                    curr = temp;
                }
            }
        }

        return postorder;
    }

    //Using 2 stacks
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack1.isEmpty()) {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack1.push(curr.left);
            }
            if (curr.right != null) {
                stack1.push(curr.right);
            }
        }

        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop().val);
        }

        return postOrder;
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

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);

            Problem145$BinaryTreePostorderTraversal obj = new Problem145$BinaryTreePostorderTraversal();
            obj.postorderTraversal(root).forEach(num -> System.out.print(num + " "));
        }
    }
}
