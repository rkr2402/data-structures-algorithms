package com.practice.problems.leetcode.linkedlist;

/**
 * Problem Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Problem Statement: Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */

public class Problem19$RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyNode.next;
    }

    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int slowCounter = 0;

        ListNode prev = null;
        while (slow != null && fast != null && fast.next != null) {
            slowCounter++;
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }


        int totalNodesCnt = fast == null ? 2 * slowCounter : 2 * slowCounter + 1;
        int nodePosition = totalNodesCnt - n + 1;


        if (nodePosition >= slowCounter) {
            while (++slowCounter < nodePosition && slow != null) {
                prev = slow;
                slow = slow.next;
            }
        } else {
            slow = head;
            slowCounter = 1;
            prev = null;

            while (slowCounter++ < nodePosition && slow != null) {
                prev = slow;
                slow = slow.next;
            }
        }

        if (prev == null) {
            return head == null ? null : head.next;
        }

        prev.next = (slow == null) ? null : slow.next;

        return head;
    }*/

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);
//        list1.next.next.next.next.next = new ListNode(6);
//        list1.next.next.next.next.next.next = new ListNode(7);
//        list1.next.next.next.next.next.next.next = new ListNode(8);

        Problem19$RemoveNthNodeFromEndOfList obj = new Problem19$RemoveNthNodeFromEndOfList();
        obj.printList(list1);

        ListNode result1 = obj.removeNthFromEnd(list1, 5);
        obj.printList(result1);
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

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
