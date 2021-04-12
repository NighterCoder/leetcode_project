package com.leetcode.study.linkedlist;

/**
 * 二维数组中的查找
 *
 * 双指针问题,一个指针沿x轴移动,一个指针沿y轴移动
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] data=new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        System.out.println(findNumberIn2DArray(data,5));


    }

    /**
     * 暴力解法 时间复杂度O(nm)
     * @param matrix
     * @param target
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==target) return true;
                // [i,j]比target大,退回到[i+1,j-1]
                if (matrix[i][j]>target){
                    break;
                }
            }
        }
        return false;
    }






}
