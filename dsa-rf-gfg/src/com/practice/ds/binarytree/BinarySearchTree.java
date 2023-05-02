package com.practice.ds.binarytree;

public class BinarySearchTree {

    private Node root;

    public Node find(int key) {
        Node current = root;

        while (current.iData != key) {
            if (current.iData > key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.fData = dd;

        if (root == null) {
            root = newNode;
        } else {
            Node parent;
            Node current = root;
            while (true) {
                parent = current;
                if (id < current.iData) { // go left
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /** ------------- TRAVERSING A BINARY TREE ---------------
     * There are 3 simple ways to traverse a binary search tree
     *     1. Preorder
     *     2. Inorder
     *     3. Postorder
     *
     * Commonly used technique for binary search tree is Inorder
     *
     * */


    /**
     * An inorder traversal of binary search tree will cause all the nodes to be visited in ascending order, based on their key values.
     * Steps -
     * 1. Call itself to traverse the nodes's left subtree.
     * 2. Visit the node
     * 3. Call itself to traverse the node's right subtree.
     */
    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.leftChild);
        System.out.println(node.iData);
        inOrderTraversal(node.rightChild);
    }

    /**
     * PreOrderTraversal Steps -
     * 1. Visit the node
     * 2. Call itself to traverse the node's left subtree.
     * 3. Call itself to traverse the node's right subtree.
     */
    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.iData);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * PostOrderTraversal Steps -
     * 1. Call itself to traverse the node's left subtree.
     * 2. Call itself to traverse the node's right subtree.
     * 3. Visit the node
     */
    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.iData);
    }

    public Node minimum() {  // returns node with the minimum key value
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last;
    }

    public Node maximum() {  // returns node with the maximum key value
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }

        return last;
    }

    /**
     * First find the node to be deleted using find() method.
     * When the node is found, there are 3 cases to be considered -
     *        1. The node to be deleted is a leaf (has no children)
     *        2. The node to be deleted has one child
     *        3. The node to be deleted has two children
     * */
    public void delete(int id) {
        Node current = root;
        Node last = root;
        boolean isLeftChild = false;

        while (id != current.iData) {
            current = last;
            if(id < current.iData) {
                current = current.leftChild;
                isLeftChild = true;
            } else {
                current = current.rightChild;
                isLeftChild = false;
            }

            if(current == null) {
                System.out.println("Could not find the node for given key");
                return;
            }
        }

        //key found
        if(current.leftChild == null && current.rightChild == null) {
            //edge case if node to be deleted is root
            if(current == root) {
                root = null;
            }
            //it is leaf node
            else if(isLeftChild) {
                last.leftChild = null;
            } else {
                last.rightChild = null;
            }
        } else if(current.rightChild == null) { // if no right child replace with left subtree
            if(current == root) {
                root = current.leftChild;
            } else if(isLeftChild) {
                last.leftChild = current.leftChild;
            } else {
                last.rightChild = current.leftChild;
            }
        } else if(current.leftChild == null) {
            if(current == root) {
                root = current.rightChild;
            } else if(isLeftChild) {
                last.rightChild = current.rightChild;
            } else {
                last.leftChild = current.rightChild;
            }
        } else {
            //node to be deleted has two children
            Node successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
                last.leftChild = successor;
            } else {
                last.rightChild = successor;
            } //end else two children case
        }
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    static class Node {

        int iData;
        double fData;
        Node leftChild;
        Node rightChild;

        public void displayNode() {

        }

    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
        Node root = new Node();
        binaryTree.root = new Node();

        //traverse the tree inorder
        binaryTree.inOrderTraversal(binaryTree.root);
        //traverse the tree preorder
        binaryTree.preOrderTraversal(binaryTree.root);
        //traverse the tree postorder
        binaryTree.postOrderTraversal(binaryTree.root);
    }
}
