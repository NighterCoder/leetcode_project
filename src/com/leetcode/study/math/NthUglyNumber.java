package com.leetcode.study.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数
 * 使用最小堆
 */
public class NthUglyNumber {
    public static void main(String[] args) {

    }

    public int nthUglyNumber(int n) {
        // 1. 首先要将最小的丑数1加入到堆中,2x,3x,5x也可以加入到堆,可以使用hash集去重
        int[] factors = {2,3,5};
        // 去重使用
        Set<Long> seen = new HashSet<>();
        // 最小堆
        PriorityQueue<Long> heap = new PriorityQueue<>();

        seen.add(1L);
        heap.offer(1L);

        int ugly = 0;
        // 第n个ugly数目
        for (int i = 0; i < n; i++) {
            // 从顶堆拿元素
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor:factors){
                // 1*2;1*3;1*4
                long next = curr * factor;
                if (seen.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
