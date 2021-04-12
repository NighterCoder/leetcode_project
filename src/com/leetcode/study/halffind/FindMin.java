package com.leetcode.study.halffind;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 寻找旋转排序数组中的最小值
 */
public class FindMin {

    public static void main(String[] args) {


    }

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l<r){
            mid = ((r-l) >> 1);
            if (nums[mid]<nums[r]){
                r=mid;
            }else{
                l=mid+1;
            }
        }

        return nums[mid];

    }


}
