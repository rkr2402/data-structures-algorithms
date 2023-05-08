package com.practice.problems.leetcode.linkedlist;

public class Problem328$OddEvenLinkedList {

    public static class ListNode {
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

    /**
     * My Solution: Maintain 2 separate list for odd and even numbered nodes
     * Time Complexity: O(n)
     * Space Complexity: O(n) or O(1) not sure
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode current = head;
        ListNode resultListNode = new ListNode(-1);//dummy result ListNode with all even
        ListNode oddListNode = resultListNode;
        ListNode firstEvenListNode = new ListNode(-2);
        ListNode evenListNode = firstEvenListNode;
        ListNode previous = null;

        int counter = 1;
        while (current != null) {
            if (counter % 2 == 0) {
                evenListNode.next = current;
                evenListNode = evenListNode.next;
                previous = current;
            } else {
                //odd no
                oddListNode.next = current;
                oddListNode = oddListNode.next;
                //delete the ListNode
                if (previous != null) {
                    previous.next = current.next;
                }
            }
            counter++;
            current = current.next;
        }

        oddListNode.next = firstEvenListNode.next;
        return resultListNode.next;
    }

    /**
     * Leetcode Solution:
     */
    public ListNode oddEvenList_LeetCodeSolution(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
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
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
//        list.next.next.next.next.next = new ListNode(5);
//        list.next.next.next.next.next.next = new ListNode(4);
//        list.next.next.next.next.next.next.next = new ListNode(1);
//        list.next.next.next.next.next.next.next.next = new ListNode(7);
//        list.next.next.next.next.next.next.next.next.next = new ListNode(6);

        Problem328$OddEvenLinkedList obj = new Problem328$OddEvenLinkedList();
        obj.printList(list);
        ListNode result = obj.oddEvenList(list);
        obj.printList(result);
    }
}
