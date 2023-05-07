package com.practice.problems.leetcode.linkedlist;

public class Problem25$ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int count = 1;
        ListNode current = head;

        while (count < k && current.next != null) {
            count++;
            current = current.next;
        }

        if(count != k) {
            return head;
        }

        ListNode first = head;
        ListNode remainingList = current.next;
        current.next = null;

        ListNode result = reverseList(head);
        first.next = reverseKGroup(remainingList, k);

        return result;
    }

    private ListNode reverseList(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }

        ListNode reverseNode = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return reverseNode;
    }

    private void printList(ListNode head) {
        System.out.print("head -> ");
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(4);
        list2.next.next.next.next = new ListNode(5);

        Problem25$ReverseNodesInKGroup obj = new Problem25$ReverseNodesInKGroup();
        obj.printList(list2);

        ListNode result1 = obj.reverseKGroup(list2, 2);
        obj.printList(result1);
    }

    private static class ListNode {
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
