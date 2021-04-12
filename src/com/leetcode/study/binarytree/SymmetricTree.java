package com.leetcode.study.binarytree;

/**
 * 对称二叉树
 *
 * 给定一个二叉树,检查它是否是镜像对称的
 *
 * ******* 需要复习
 *
 */
public class SymmetricTree {

    public static void main(String[] args) {

    }


    public static boolean isSymmetric(TreeNode root) {
        return isSymmetry(root,root);


    }

    public static boolean isSymmetry(TreeNode left,TreeNode right){

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return left.val==right.val &&
                isSymmetry(left.left,right.right)&&
                isSymmetry(left.right,right.left);

    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
