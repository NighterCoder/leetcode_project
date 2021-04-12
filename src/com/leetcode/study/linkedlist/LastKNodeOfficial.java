package com.leetcode.study.linkedlist;

/**
 * 链表中倒数第k个节点
 * <p>
 * 双指针解法,使用双指针不用统计链表长度
 * <p>
 * 流程：
 * 1.初始化:前指针former、后指针latter,双指针指向头节点
 * 2.构建双指针距离：前指针 former 先向前走 k 步（结束后，双指针 former 和 latter 间相距 k 步）
 * 3.双指针共同移动：循环中，双指针 former 和 latter 每轮都向前走一步，直至 former 走过链表 尾节点 时跳出（跳出后， latter 与尾节点距离为 k-1，即 latter 指向倒数第 k 个节点）
 * 4.返回latter
 */
public class LastKNodeOfficial {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        // 将former向前走k步
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
