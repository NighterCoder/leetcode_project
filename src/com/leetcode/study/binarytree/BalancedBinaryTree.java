package com.leetcode.study.binarytree;

/**
 * 平衡二叉树
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        // 判断是不是平衡二叉树
        // 1.左子树和右子树必须是平衡二叉树
        // 2.左子树和右子树高度差距为一
        if (root==null) return true;

        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(getHeight(root.left)-getHeight(root.right))<=1;

    }

    // 计算高度,左子树和右子树中最深的+1
    public static int getHeight(TreeNode root){
        if (root==null) return 0;
        // 后序遍历
        int l=getHeight(root.left);
        int r=getHeight(root.right);
        return Math.max(l, r)+1;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


