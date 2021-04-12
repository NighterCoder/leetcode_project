package com.leetcode.study.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/balance-a-binary-search-tree/
 * <p>
 * 将二叉搜索树变平衡
 * <p>
 * 先找到升序排列的数组;再去重建二叉搜索树
 */
public class BalanceBST {
    public static void main(String[] args) {

    }

    List<Integer> nums = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        sortNums(root);
        int[] values = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            values[i] = nums.get(i);
        }
        return generateTree(values, 0, values.length - 1);

    }

    /**
     * 构建二叉搜索树
     *
     * @param values
     * @return
     */
    public TreeNode generateTree(int[] values, int i, int j) {
        if (i > j) return null;
        if (i == j) return new TreeNode(values[i]);
        // 定位中位数
        int m = i + (j - i) / 2;
        TreeNode root = new TreeNode(values[m]);
        root.left = generateTree(values, i, m - 1);
        root.right = generateTree(values, m + 1, j);
        return root;

    }


    public void sortNums(TreeNode root) {
        if (root != null) {
            sortNums(root.left);
            nums.add(root.val);
            sortNums(root.right);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
