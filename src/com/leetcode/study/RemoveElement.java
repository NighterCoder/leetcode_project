package com.leetcode.study;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums=new int[]{4,5};

        System.out.println(removeElement(nums,4));

    }

    /**
     * 删除元素
     *
     * @param nums
     * @param val
     */
    public static int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j = i + 1;
                if (j==nums.length){
                    return i;
                }
                while (nums[j] == val) {
                    j++;
                    if (j>nums.length-1){
                        break;
                    }
                }
                if (j>nums.length-1){
                    return i;
                }else {
                    // 交换
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return nums.length;
    }
}
