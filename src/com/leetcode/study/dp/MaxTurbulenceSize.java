package com.leetcode.study.dp;

/**
 * 最长湍流子数组
 */
public class MaxTurbulenceSize {

    public static void main(String[] args) {

    }

    /**
     * @param arr 数组
     */
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];

        dp[0][0] = dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i][1] = 1;
            if (arr[i - 1] > arr[i]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else if (arr[i - 1] < arr[i]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }

        int ret = 1;
        for (int i = 0; i < n; i++) {
           ret = Math.max(ret,dp[i][0]);
           ret = Math.max(ret,dp[i][1]);
        }
        return ret;
    }
}
