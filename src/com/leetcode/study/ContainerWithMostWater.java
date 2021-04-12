package com.leetcode.study;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] res = new int[]{1,2,1};
        System.out.println(maxArea(res));
    }


    public static int maxArea(int[] height) {
        int res = 0;
        // 转换问题
        for (int i = 0; i < height.length - 1; i++) {
            int leftVal = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int rightVal = height[j];
                int val;
                if (rightVal < leftVal) {
                    val = rightVal * (j - i);
                } else {
                    val = leftVal * (j - i);
                }
                if (val > res ){
                    res = val;
                }
            }
        }

        return res;

    }
}
