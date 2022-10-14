import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    public int rob(TreeNode root) {
        //根据提示，至少有一个节点。所以不用判断根节点为null
        int[] res = dfs(root);   //得到根节点偷或不偷的状态
        return Math.max(res[0], res[1]); //取最大值
    }
 
    private int[] dfs(TreeNode node) {
        //每个房子有两个状态，[偷,不偷]
        //对于当前房子：1.偷当前房子，那么孩子节点不能偷 2.不偷，那么可以'考虑'偷孩子节点
        //采用左右根遍历--理解为从叶子开始向上偷
        //如果不存在孩子节点，那么状态初始化为[0,0]，这样以后相加对结果没影响
        int[] left = new int[2];   
        int[] right = new int[2];

        if(node.left != null) left = dfs(node.left);
        if(node.right != null) right = dfs(node.right);

        return new int[]{
                node.val + left[1] + right[1], //推导偷当前节点的价值
                Math.max(left[0], left[1]) + Math.max(right[0], right[1])   //不偷当前节点
            };
    }
}
// @lc code=end

