package com.practice.ds.binarytree;

import java.util.LinkedList;
import java.util.List;

public class DiameterOfBinaryTree extends BinaryTree {

    public int diameter() {
        Height h = new Height();
        return helper(this.root, h);
    }

    private int helper(Node root, Height height) {
        Height leftTreeHeight = new Height();
        Height rightTreeHeight = new Height();

        if(root == null) {
            height.height = 0;
            return 0;
        }

        int leftTreeDiameter = helper(root.left, leftTreeHeight);
        int rightTreeDiameter = helper(root.right, rightTreeHeight);

        height.height = Math.max(leftTreeHeight.height, rightTreeHeight.height) + 1;

        return Math.max(leftTreeHeight.height + rightTreeHeight.height + 1, Math.max(leftTreeDiameter, rightTreeDiameter));
    }

    static class Height {
        int height;
    }

    public static void main(String[] args) {
        int[][][] threeDArr = new int[2][3][4];
        double temp = -1e8;
        System.out.println(temp);

        DiameterOfBinaryTree binaryTree = new DiameterOfBinaryTree();
//        Node root = new Node(10);
        binaryTree.insert(null, 10);
        binaryTree.insert(binaryTree.root, 11);
        binaryTree.insert(binaryTree.root, 7);
        binaryTree.insert(binaryTree.root, 15);
        binaryTree.insert(binaryTree.root, 8);

        binaryTree.inOrderTraversal(binaryTree.root);
//        System.out.println(binaryTree.diameter());
    }

}
