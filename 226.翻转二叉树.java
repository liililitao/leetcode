import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    //天呐这太简单了吧，就换一下然后递归，秒杀！！！
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        //交换左右子树
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree(root.left);//翻转左子树
        invertTree(root.right);//翻转右子树
        return root;//返回根节点
    }
}
// @lc code=end

