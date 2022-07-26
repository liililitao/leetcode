/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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
    //啊哈哈哈，我简直是天才！！！
    public int findTilt(TreeNode root) {
        if(root == null)
            return 0;
        int s = 0;
        s += nodeSlope(root);//加上根节点的坡度
        s += findTilt(root.left);//加上整个左子树的坡度
        s += findTilt(root.right);//加上整个右子树的坡度
        return s;//返回整个树的坡度
    }
    int nodeSlope(TreeNode root) {//返回root节点的坡度
        if(root == null)
            return 0;
        //该节点左子树的节点之和和右子树节点之和的差的绝对值
        return Math.abs(nodeSum(root.left) - nodeSum(root.right));
    }
    int nodeSum(TreeNode root) {//返回以root为根节点的树的节点总和
        if(root == null)
            return 0;
        int sum = 0;
        sum += root.val;//根节点的值
        sum += nodeSum(root.left);//加上左子树的节点总和
        sum += nodeSum(root.right);//加上右子树的节点总和
        return sum;
    }
}
// @lc code=end

