package com.practice.problems.leetcode.linkedlist;

/**
 * Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * <p>
 * Problem Statement:
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.
 * The most significant bit is at the head of the linked list.
 * <p>
 * Input: head = [1,0,1]
 * Output: 5
 */

public class Problem1290$ConvertBinaryToNumber {

    public int getDecimalValue(ListNode head) {
        int currVal = head.val;
        ListNode node = head;

        while (node.next != null) {
            currVal = currVal * 2 + node.next.val;
            node = node.next;
        }
        return currVal;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(0);
        list1.next.next = new ListNode(1);
        list1.next.next.next = new ListNode(1);

        Problem1290$ConvertBinaryToNumber obj = new Problem1290$ConvertBinaryToNumber();
        System.out.println("List1 output is " + obj.getDecimalValue(list1));

        ListNode list2 = new ListNode(0);
        System.out.println("List2 output is " + obj.getDecimalValue(list2));
    }


}

class ListNode {
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
