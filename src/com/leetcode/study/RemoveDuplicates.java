package com.leetcode.study;

/**
 * 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

    }

    // 有序数组
    public static int removeDuplicates(int[] nums) {
        // 双指针
        int n = nums.length;
        if (n<=2){
            return n;
        }

        // 1 1 1 2 2 3
        int slow=2,fast=2;
        while (fast < n){
            if (nums[slow-2] != nums[fast]){
                // 将数据向前移动
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }

        return slow;
    }


}
