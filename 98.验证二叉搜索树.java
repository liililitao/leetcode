/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    //二叉搜索树中序遍历应该是有序的
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left))//遍历左子树，如果左子树不是二叉搜索树
            return false;//返回false
        if(root.val <= pre)//如果中序遍历root的值小于等于前一个结点的值
            return false;//说明不是二叉搜索树
        pre = root.val;//更新pre的值
        return isValidBST(root.right);//遍历右子树
    }
}
// @lc code=end

