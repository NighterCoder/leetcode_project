package com.leetcode.study.binarytree;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/submissions/
 *
 * 平衡二叉树 easy
 *
 *
 * */
public class BalancedTree {
    public static void main(String[] args) {

    }

    /**
     * 是否是平衡二叉树
     * @param root
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        // 是平衡二叉树,那么当前节点的左子树和右子树都是平衡二叉树
        return isBalanced(root.left) && isBalanced(root.right) &&
                Math.abs(getHeight(root.left)-getHeight(root.right))<=1;

    }


    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }else{
            // 后序遍历
            int maxDepth = Math.max(getHeight(root.left),getHeight(root.right));
            return maxDepth+1;
        }
    }


    public class TreeNode {
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
