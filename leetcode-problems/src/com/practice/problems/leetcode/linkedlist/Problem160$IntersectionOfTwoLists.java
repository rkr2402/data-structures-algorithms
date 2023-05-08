package com.practice.problems.leetcode.linkedlist;

/**
 *
 */

public class Problem160$IntersectionOfTwoLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode list1 = headA;
        ListNode list2 = headB;

        while (list1 != list2) {
            list1 = list1 == null ? headB : list1.next;
            list2 = list2 == null ? headA : list2.next;
        }

        return list1;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(5);
        list1.next = new ListNode(6);
        list1.next.next = new ListNode(1);
        ListNode node1 = new ListNode(8);
        list1.next.next.next = node1;
        ListNode n2 = new ListNode(4);
        list1.next.next.next.next = n2;
        ListNode n3 = new ListNode(5);
        list1.next.next.next.next.next = n3;

        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(1);
//        list2.next.next = node1;
//        list2.next.next.next = n2;
//        list2.next.next.next.next = n3;

        Problem160$IntersectionOfTwoLists obj = new Problem160$IntersectionOfTwoLists();
        obj.printList(list1);
        obj.printList(list2);

        ListNode resultNode = obj.getIntersectionNode(list1, list2);
        if(resultNode == null) {
            System.out.println("resultNode is null");
            return;
        }
        System.out.println(resultNode.val);
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
