package com.leetcode.study.binarytree;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * <p>
 * 二叉树的最大深度
 * <p>
 * easy 需要复习
 */
public class MaxDepth {
    public static void main(String[] args) {

    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int maxDepth = Math.max(
                    maxDepth(root.left),
                    maxDepth(root.right)
            );
            return maxDepth + 1;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
