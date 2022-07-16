/*
 * @lc app=leetcode.cn id=2236 lang=java
 *
 * [2236] 判断根结点是否等于子结点之和
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
    //这题..............
    public boolean checkTree(TreeNode root) {
        if(root.val == (root.left.val + root.right.val))
            return true;
        else
            return false;
    }
}
// @lc code=end

