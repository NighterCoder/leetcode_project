package com.leetcode.study.binarytree;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * <p>
 * 完全二叉树的节点个数
 */
public class CountNodes {

    public static void main(String[] args) {

    }

    int count = 0;

    /**
     * 粗暴解法,直接遍历所有节点
     *
     * @param root
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            // 粗暴解法
            count += 1;
            countNodes(root.left);
            countNodes(root.right);
            return count;
        }
    }


    public int countNodes2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int level = 0; // 层数是从0开始
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }

        // 最后一层节点个数
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        while (low < high){
            int mid = (high - low +1) /2 +low;
            if (exists(root,level,mid)){
                // 能找到,说明总节点一定大于mid
                low = mid;
            }else{
                // 不能找到,说明总节点一定小于mid
                high = mid - 1;
            }
        }
        return low;

    }

    public boolean exists(TreeNode root,int level,int k){
        // 用来判断位是否存在,第一位不算
        int bits = 1 << (level-1);
        TreeNode node = root;
        while (node!=null && bits > 0){
            if ((bits & k) == 0){
                // 左子节点
                node = node.left;
            }else{
                node = node.right;
            }

            bits >>= 1;
        }
        return node!=null;
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
