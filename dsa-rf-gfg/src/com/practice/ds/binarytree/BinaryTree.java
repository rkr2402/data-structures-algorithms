package com.practice.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;
    Node temp = root;

    public void insert(Node temp, int key) {
        if(temp == null) {
            root = new Node(key);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();

            if(temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                queue.add(temp.left);
            }

            if(temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    public void inOrderTraversal(Node node) {
        if(node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.println(node.key);
        inOrderTraversal(node.right);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
//        Node root = new Node(10);
        binaryTree.insert(null, 10);
        binaryTree.insert(binaryTree.root, 11);
        binaryTree.insert(binaryTree.root, 7);
        binaryTree.insert(binaryTree.root, 15);
        binaryTree.insert(binaryTree.root, 8);

        binaryTree.inOrderTraversal(binaryTree.root);
    }
}
