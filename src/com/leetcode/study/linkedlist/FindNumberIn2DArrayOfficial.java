package com.leetcode.study.linkedlist;

/**
 * 二维数组中的查找
 *
 * 双指针问题,一个指针沿x轴移动,一个指针沿y轴移动
 */
public class FindNumberIn2DArrayOfficial {
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
     * 线性查找
     * 从 右上角 开始查找。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行
     *
     * @param matrix
     * @param target
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows=matrix.length,columns=matrix[0].length;
        int row=0,column=columns-1;

        while (row<rows && column>=0){
            int num=matrix[row][column];
            if (num==target) {
                return true;
            }else if (num>target){
                // 移到左边一列
                column--;
            }else{
                row++;
            }
        }
        return false;
    }
}
