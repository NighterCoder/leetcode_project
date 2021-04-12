package com.leetcode.study.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ReBuildTree {
    public static void main(String[] args) {

    }

    /**
     * 前序遍历
     * @param preorder
     * @param inorder
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length==0){
            return null;
        }

        Map<Integer,Integer> indexMap=new HashMap<>();
        int length=preorder.length;

        for (int i=0;i<length;i++){
            indexMap.put(inorder[i],i);
        }
        // 根据前序遍历的第一个值作为根节点
        // 中序遍历中根节点左边的值是左子树,右边的值是右子树
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;

    }

    public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap){
        if (preorderStart > preorderEnd) {
            return null;
        }
        // 根值
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        }else {
            // 根节点在中序遍历中的位置
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
