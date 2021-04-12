package com.leetcode.study.binarytree;

import java.util.LinkedList;

/**
 * 从上打印二叉树
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class PrintBinaryTree {

    static LinkedList<Integer> numList=new LinkedList<Integer>();

    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {

        if (root==null) return null;
        numList.add(root.val);
        getValues(root);
        int[] res=new int[numList.size()];
        for (int i=0;i<res.length;i++){
            res[i]=numList.get(i);
        }
        return res;

    }


    public static void getValues(TreeNode root){
        if (root.left!=null&&root.right!=null) {
            numList.add(root.left.val);
            numList.add(root.right.val);
            getValues(root.left);
            getValues(root.right);
        }else if(root.left!=null){
            numList.add(root.left.val);
            getValues(root.left);
        }else if(root.right!=null){
            numList.add(root.right.val);
            getValues(root.right);
        }
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
