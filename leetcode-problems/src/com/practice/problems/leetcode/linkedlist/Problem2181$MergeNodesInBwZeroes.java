package com.practice.problems.leetcode.linkedlist;

/**
 * Leetcode URL: https://leetcode.com/problems/merge-nodes-in-between-zeros/
 * Problem Statement: You are given the head of a linked list, which contains a series of integers separated by 0's.
 * The beginning and end of the linked list will have Node.val == 0.
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes.
 * The modified list should not contain any 0's.
 * <p>
 * Return the head of the modified linked list.
 */
public class Problem2181$MergeNodesInBwZeroes {

    public ListNode mergeNodes(ListNode head) {
        ListNode resultNode = new ListNode(-1);
        ListNode result = resultNode;
        ListNode current = head;
        int sum = 0;

        while (current != null) {

            if (current.val == 0) {
                if (sum != 0) {
                    resultNode.next = new ListNode(sum);
                    resultNode = resultNode.next;
                    sum = 0;
                }
            } else {
                sum = sum + current.val;
            }
            current = current.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(1);
        list1.next.next.next = new ListNode(0);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);
        list1.next.next.next.next.next.next = new ListNode(2);
        list1.next.next.next.next.next.next.next = new ListNode(0);

        Problem2181$MergeNodesInBwZeroes obj = new Problem2181$MergeNodesInBwZeroes();
        obj.printList(list1);
        ListNode resultNode = obj.mergeNodes(list1);
        obj.printList(resultNode);
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


