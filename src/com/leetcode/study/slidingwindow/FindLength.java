package com.leetcode.study.slidingwindow;


/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
 * <p>
 * 最长重复子数组
 * 使用滑动窗口算法
 */
public class FindLength {

    public static void main(String[] args) {

    }

    public static int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        // B数组不动,A数组向后移动
        for (int i = 0; i < n; i++) {
            int len = Math.min(m,n-i);
            int maxLen = maxLength(A,B,i,0,len);
            ret= Math.max(ret,maxLen);
        }

        for (int i=0;i<m;i++){
            int len = Math.min(n,m-1);
            int maxLen=maxLength(A,B,0,i,len);
            ret = Math.max(ret,maxLen);
        }

        return ret;
    }

    public static int maxLength(int[] A, int[] B, int addA, int addB, int length) {
        int k = 0, ret = 0;
        // 最多移动length个字符
        for (int i = 0; i < length; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            // 保留最大的值
            ret = Math.max(ret, k);
        }
        return ret;
    }
}
