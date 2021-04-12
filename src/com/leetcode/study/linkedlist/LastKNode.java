package com.leetcode.study.linkedlist;

/**
 * 2020/11/13
 * 剑指Offer 22
 * 链表中倒数第K个节点
 */
public class LastKNode {

    public static void main(String[] args) {

        ListNode fifthNode = new ListNode(5);
        ListNode fourthNode = new ListNode(4);
        ListNode thirdNode = new ListNode(3);
        ListNode secondNode = new ListNode(2);
        ListNode firstNode = new ListNode(1);
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        System.out.println(getKthFromEnd(firstNode, 2));
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode res = head;
        //从头节点开始遍历
        int size = 1;
        while (head.next != null) {
            head = head.next;
            size += 1;
        }
        int length = size - k;

        ListNode node;
        for (int i = length; i > 0; i--) {
            assert res != null;
            res = res.next;
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
