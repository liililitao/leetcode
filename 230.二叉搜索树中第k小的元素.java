import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    //因为是二叉搜索树，所以中序遍历是有序的
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        f(root, list);//将中序遍历的结果放入list中
        return list.get(k - 1);//返回第k-1个元素，即第k小元素
    }
    List<Integer> f(TreeNode root, List<Integer> list) {//中序遍历
        if(root == null) return list;
        f(root.left, list);
        list.add((root.val));
        f(root.right, list);
        return list;
    }
}
// @lc code=end

