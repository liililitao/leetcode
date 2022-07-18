/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    //so easy啦！！！递归就可以
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 1;//根节点个数为1
        if(root.left != null) {//有左孩子
            count += countNodes(root.left);//加上以左孩子为根节点的树的节点个数
        }
        if(root.right != null) {//有右孩子
            count += countNodes(root.right);//加上以右孩子为根节点的树的节点个数
        }
        return count;//返回总个数
    }
}
// @lc code=end

