package com.practice.ds.linkedlist.gfgprograms;

public class ReverseNodesInGroupsOfK {

    public Node reverse(Node node, int k) {
        if(node == null || node.next == null) {
            return node;
        }

        int count = 1;
        Node current = node;

        while (count < k && current.next != null) {
            count++;
            current = current.next;
        }

        Node first = node;
        Node remainingList = current.next;
        current.next = null;

        Node result = reverseList(node);
        first.next = reverse(remainingList, k);

        return result;
    }

    private Node reverseList(Node node) {
        if(node == null || node.next == null) {
            return node;
        }

        Node reverseNode = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return reverseNode;
    }

    private void printList(Node head) {
        System.out.print("head -> ");
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node list1 = new Node(17);
        list1.next = new Node(15);
        list1.next.next = new Node(8);
        list1.next.next.next = new Node(12);
        list1.next.next.next.next = new Node(10);
        list1.next.next.next.next.next = new Node(5);
        list1.next.next.next.next.next.next = new Node(4);
        list1.next.next.next.next.next.next.next = new Node(1);
        list1.next.next.next.next.next.next.next.next = new Node(7);
        list1.next.next.next.next.next.next.next.next.next = new Node(6);

        ReverseNodesInGroupsOfK obj = new ReverseNodesInGroupsOfK();
        obj.printList(list1);

        Node res = obj.reverse(list1, 4);
        obj.printList(res);

        //list 2
        Node list2 = new Node(1);
        list2.next = new Node(2);
        list2.next.next = new Node(3);
        list2.next.next.next = new Node(4);
        list2.next.next.next.next = new Node(5);
        obj.printList(list2);

        Node result = obj.reverse(list2, 3);
        obj.printList(result);
    }

    private static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }
}
