package com.practice.problems.leetcode.linkedlist;

/**
 * Problem URL: https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Problem Statement: 
 */
public class Problem237$DeleteNodeInLinkedList {

    //Leetcode Solution
    class Solution {
        public void deleteNode(ListNode node) {
            // Since we know input node is not last node, so nextNode will not be null
            ListNode nextNode = node.next;
            // Step 2
            node.val = nextNode.val;
            // Step 3
            node.next = nextNode.next;
            nextNode.next = null;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while (curr.next != null) {
            prev = curr;
            curr.val = curr.next.val;
            curr = curr.next;
        }

        prev.next = null;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
        list1.next.next.next.next.next = new ListNode(6);
        list1.next.next.next.next.next.next = new ListNode(7);
        list1.next.next.next.next.next.next.next = new ListNode(8);

        Problem237$DeleteNodeInLinkedList obj = new Problem237$DeleteNodeInLinkedList();
        obj.printList(list1);

        obj.deleteNode(list1);
        obj.printList(list1);
    }

    private void printList(ListNode head) {
        System.out.print("head -> ");
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

    }
}
