package com.leetcode.study.bst;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 将二叉搜索树转换为累加树
 */
public class ConvertBst {
    public static void main(String[] args) {

    }


    int num = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        // 节点的值
        root.val= root.val+num;
        // 更新num值
        num = root.val;
        convertBST(root.left);
        return root;

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
