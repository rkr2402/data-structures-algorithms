package com.practice.problems.leetcode.linkedlist;

public class Problem61$RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode last = head;

        while (last.next != null) {
            len++;
            last = last.next;
        }

        k = k > len ? k % len : k;
        if(k == len) return head;

        k = len - k;
        int count = 1;

        ListNode curr = head;

        while(count < k) {
            count++;
            curr = curr.next;
        }

        last.next = head;
        head = curr.next;
        curr.next = null;

        return head;
    }

    /*
     * My Solution: Gave StackOverflow Error
     * head = [1,2,3], k = 2000000000
     * */
    /*public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode resultNode = new ListNode(-1);
        ListNode lastNode = head;
        ListNode penultimateLastNode = null;

        while (lastNode.next != null) {
            penultimateLastNode = lastNode;
            lastNode = lastNode.next;
        }

        penultimateLastNode.next = null;
        lastNode.next = head;
        head = lastNode;

        return rotateRight(head, k - 1);

    }*/

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
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        Problem61$RotateLinkedList obj = new Problem61$RotateLinkedList();
        obj.printList(list1);
        ListNode resultNode = obj.rotateRight(list1, 2);
        obj.printList(resultNode);

        //TEST CASE 2
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);

        obj.printList(list2);
        ListNode resultNode2 = obj.rotateRight(list2, 2000000000);
        obj.printList(resultNode2);

        //TEST CASE 2
        ListNode list3 = new ListNode(0);
        list3.next = new ListNode(1);
        list3.next.next = new ListNode(2);

        obj.printList(list3);
        ListNode resultNode3 = obj.rotateRight(list3, 4);
        obj.printList(resultNode3);
    }
}
