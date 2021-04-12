package com.leetcode.study.math;

/**
 *
 */
public class IsUgly {

    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }

    /**
     * 超出时间限制
     */
    public static boolean isUgly(int n) {
        if (n == 1) return true;
        while (n % 2 == 0 || n % 3 == 0 || n % 5 == 0) {
            if (n % 2 == 0) {
                n = n / 2;
            }
            if (n % 3 == 0) {
                n = n / 3;
            }
            if (n % 5 == 0) {
                n = n / 5;
            }
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUgly2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }


}
