import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    //哈哈，so easy拉！
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = InorderTraversal(root, list);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++) {//找差最小的
            if(min > list.get(i) - list.get(i - 1))
                min = list.get(i) - list.get(i - 1);
        }
        return min;
    }
    //中序遍历，写了好多次了
    List<Integer> InorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        InorderTraversal(root.left, list);
        list.add(root.val);
        InorderTraversal(root.right, list);
        return list;
    }
}
// @lc code=end

