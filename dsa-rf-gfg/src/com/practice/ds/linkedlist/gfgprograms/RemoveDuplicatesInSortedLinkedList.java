package com.practice.ds.linkedlist.gfgprograms;

public class RemoveDuplicatesInSortedLinkedList {

    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        Node current = head;
        Node previousValidNode = head;
        int currentNumber = current.data;

        while (current.next != null) {
            current = current.next;
            if (current.data == currentNumber) {
                //delete the node
                previousValidNode.next = current.next;
            } else {
                currentNumber = current.data;
                previousValidNode = current;
            }
        }

        return head;
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
        Node list1 = new Node(2);
        list1.next = new Node(2);
        list1.next.next = new Node(2);
        list1.next.next.next = new Node(2);

        RemoveDuplicatesInSortedLinkedList obj = new RemoveDuplicatesInSortedLinkedList();
        obj.printList(list1);
        Node result1 = obj.removeDuplicates(list1);
        obj.printList(result1);
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
