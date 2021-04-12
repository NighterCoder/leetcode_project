package com.leetcode.study.binarytree;

import com.leetcode.study.DeleteDuplicates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 不同的二叉搜索树
 * <p>
 * 二叉搜索树构造
 */
public class GenerateTrees {

    public static void main(String[] args) {
        generateTrees(3);
    }

    /**
     * 1到n构造二叉搜索树
     *
     * @param n
     */
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();

        return generateNode(1, n);
    }

    public static List<TreeNode> generateNode(int start, int end) {

        List<TreeNode> res = new LinkedList<TreeNode>();

        if (start > end) {
            res.add(null);
            return res;
        }

        // i作为根节点
        for (int i = start; i <= end; i++) {
            // 构造左子树
            List<TreeNode> left = generateNode(start, i - 1);
            // 构造右子树
            List<TreeNode> right = generateNode(i + 1, end);
            for (TreeNode leftEle : left) {
                for (TreeNode eightEle : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftEle;
                    treeNode.right = eightEle;
                    res.add(treeNode);
                }
            }
        }

        return res;
    }


    public static class TreeNode {
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
