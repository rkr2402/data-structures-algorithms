package com.practice.problems.leetcode.linkedlist;

public class Problem234$PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        ListNode temp = head;

        slow = slow.next;
        while (slow != null) {
            if (slow.val != temp.val) {
                return false;
            }
            slow = slow.next;
            temp = temp.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        ListNode next = node.next;

        while (next != null) {
            ListNode n = next.next;
            next.next = curr;
            curr.next = prev;
            prev = curr;
            curr = next;
            next = n;
        }
        return curr;
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

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(1);
//        list1.next.next = new ListNode(3);
//        list1.next.next.next = new ListNode(4);
//        list1.next.next.next.next = new ListNode(4);
//        list1.next.next.next.next.next = new ListNode(3);
//        list1.next.next.next.next.next.next = new ListNode(2);
//        list1.next.next.next.next.next.next.next = new ListNode(1);

        Problem234$PalindromeLinkedList obj = new Problem234$PalindromeLinkedList();
        obj.printList(list1);
//        ListNode resultNode = obj.reverse(list1);
//        obj.printList(resultNode);

        System.out.println(obj.isPalindrome(list1));
    }
}
