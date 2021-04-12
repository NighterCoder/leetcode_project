package com.leetcode.study.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 水果成篮
 * <p>
 * 第i棵树产生tree[i]型的水果：
 * 实际上就是 数组内最大连续n个数,有2个不同的数
 * <p>
 * 出现两个不同的数,停止计数,出现最大的数值
 * <p>
 * 双指针？？找出最长子序列
 */
public class TotalFruit {
    public static void main(String[] args) {

        int[] rs = new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit1(rs));


    }

    /**
     * 超出时间限制
     *
     * @param tree
     */
    public static int totalFruit(int[] tree) {
        int count = 0;
        int rs = 0;
        for (int i = 0; i < tree.length; i++) {
            Set<Integer> numSet = new HashSet<>();
            for (int j = i; j < tree.length; j++) {
                numSet.add(tree[j]);
                if (numSet.size() > 2) {
                    break;
                }
                count++;
            }
            // 计数大于当前结果
            if (count > rs) {
                rs = count;
            }
            count = 0;
        }
        return rs;
    }


    /**
     * 双指针
     * <p>
     * 寻找最大子序列（ 一个指针负责向后找(Map存储,key为值,value为计数值),一个指针负责定位首位 ）
     *
     * @param tree
     */
    public static int totalFruit1(int[] tree) {
        int ans = 0, i = 0;
        Counter count = new Counter();
        for (int j = 0; j < tree.length; j++) {
            // 计数+1
            count.add(tree[j], 1);
            // 超过2个key
            while (count.size() >= 3) {
                // 相应值计数-1
                count.add(tree[i], -1);
                if (count.get(tree[i]) == 0) {
                    count.remove(tree[i]);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    static class Counter extends HashMap<Integer, Integer> {
        public int get(int k) {
            return containsKey(k) ? super.get(k) : 0;
        }

        // 对键key进行计数
        public void add(int k, int v) {
            put(k, get(k) + v);
        }

    }


}
