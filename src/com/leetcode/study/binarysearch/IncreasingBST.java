package com.leetcode.study.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 递增顺序查找树
 *
 * 已通过 中序遍历+构造树
 *
 */
public class IncreasingBST {

    private static List<Integer> values=new ArrayList<>();
    private static TreeNode cur;

    public static void main(String[] args) {



    }


    public static TreeNode increasingBST(TreeNode root) {

        if (root==null) return null;
        getNodeVal(root);
        Collections.sort(values);
        // 构造树
        TreeNode res=new TreeNode(0);
        // 赋值变量
        cur=res;
        for (Integer ele:values){
            cur.right=new TreeNode(ele);
            cur=cur.right;
        }
        // 返回res的右子树
        return res.right;

    }




    public static void getNodeVal(TreeNode root){
        if (root.left!=null) {
            getNodeVal(root.left);
        }
        values.add(root.val);
        if (root.right!=null) {
            getNodeVal(root.right);
        }
    }




    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
