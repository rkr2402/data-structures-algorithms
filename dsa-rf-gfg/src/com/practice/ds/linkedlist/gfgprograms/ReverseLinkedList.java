package com.practice.ds.linkedlist.gfgprograms;

/**
 * Given pointer to the head node of a linked list, the task is to reverse the linked list.
 * We need to reverse the list by changing the links between nodes.
 * <p>
 * Input: Head of following linked list
 * 1->2->3->4->NULL
 * Output: Linked list should be changed to,
 * 4->3->2->1->NULL
 */
public class ReverseLinkedList {

    //Function to reverse a linked list using iterative approach.
    Node reverseList(Node head) {
        // code here
        Node current = head;
        Node next;
        Node previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            head = current;
            current = next;
        }
        return head;
    }

    //reverse using recursion
    Node reverse(Node head) {
        if(head ==null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private void printList(Node head) {
        System.out.print("head -> ");
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node list = new Node(17);
        list.next = new Node(15);
        list.next.next = new Node(8);
        list.next.next.next = new Node(12);
        list.next.next.next.next = new Node(10);
        list.next.next.next.next.next = new Node(5);
        list.next.next.next.next.next.next = new Node(4);
        list.next.next.next.next.next.next.next = new Node(1);
        list.next.next.next.next.next.next.next.next = new Node(7);
        list.next.next.next.next.next.next.next.next.next = new Node(6);

        ReverseLinkedList obj = new ReverseLinkedList();
        obj.printList(list);
//        Node result = obj.reverseList(list);
        Node result = obj.reverse(list);
        obj.printList(result);
    }
}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
