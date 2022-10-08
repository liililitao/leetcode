/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //递归大法好！！！
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return 1;
        int res = Integer.MAX_VALUE;
        if(root.left != null)
            res = Math.min(res, minDepth(root.left));
        if(root.right != null)
            res = Math.min(res, minDepth(root.right));
        return res + 1;//还要加上根节点这一层
    }
}
// @lc code=end

