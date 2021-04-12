package com.leetcode.study.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树层序遍历
 * 层次遍历二叉树
 *
 * 一边poll,一边add
 *
 * 已通过
 */
public class LevelOrder {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 层序遍历
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        while (!nodes.isEmpty()) {
            List<Integer> currList = new ArrayList<>();
            // 同一层放在同一个List中
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (node != null) {
                    currList.add(node.val);
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
            }
            res.add(currList);
        }
        return res;

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
