package com.practice.ds.linkedlist.gfgprograms;

/**
 * https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 * <p>
 * Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list.
 * Also, keep the order of even and odd numbers same.
 * <p>
 * Input: 17->15->8->12->10->5->4->1->7->6->NULL
 * Output: 8->12->10->4->6->17->15->5->1->7->NULL
 */
public class SegregateEvenOddNodes {

    Node head;  // head of list

    /* Linked list Node*/
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    public Node segregateEvenOdd(Node head) {
        Node current = head;
        Node resultNode = new Node(-2);//dummy result node with all even
        Node evenNode = resultNode;
        Node firstOddNode = new Node(-1);
        Node oddNode = firstOddNode;
        Node previous = null;

        while (current != null) {
            if (current.data % 2 == 0) {
                evenNode.next = current;
                evenNode = evenNode.next;
                //delete the node
                if(previous != null) {
                    previous.next = current.next;
                }
            } else {
                //odd no
                oddNode.next = current;
                oddNode = oddNode.next;
                previous = current;
            }
            current = current.next;
        }

        evenNode.next = firstOddNode.next;
        return resultNode.next;
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
        /*Node list = new Node(17);
        list.next = new Node(15);
        list.next.next = new Node(8);
        list.next.next.next = new Node(12);
        list.next.next.next.next = new Node(10);
        list.next.next.next.next.next = new Node(5);
        list.next.next.next.next.next.next = new Node(4);
        list.next.next.next.next.next.next.next = new Node(1);
        list.next.next.next.next.next.next.next.next = new Node(7);
        list.next.next.next.next.next.next.next.next.next = new Node(6);

        SegregateEvenOddNodes obj = new SegregateEvenOddNodes();
        obj.printList(list);
        Node result = obj.segregateEvenOdd(list);
        obj.printList(result);*/


        Node list = new Node(4);
        list.next = new Node(6);
        list.next.next = new Node(8);
        /*list.next.next.next = new Node(12);
        list.next.next.next.next = new Node(10);
        list.next.next.next.next.next = new Node(5);
        list.next.next.next.next.next.next = new Node(4);
        list.next.next.next.next.next.next.next = new Node(1);
        list.next.next.next.next.next.next.next.next = new Node(7);
        list.next.next.next.next.next.next.next.next.next = new Node(6);*/

        SegregateEvenOddNodes obj = new SegregateEvenOddNodes();
        obj.printList(list);
        Node result = obj.segregateEvenOdd(list);
        obj.printList(result);
    }
}
