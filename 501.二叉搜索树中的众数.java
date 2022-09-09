import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    // 中序遍历
    public void inOrder(TreeNode root, List<Integer> lst) {
        if (root == null) {
            return;
        }
        inOrder(root.left, lst);
        lst.add(root.val);
        inOrder(root.right, lst);
    }

    public int[] findMode(TreeNode root) {
        List<Integer> lst = new ArrayList<Integer>();
        inOrder(root, lst);
        // 记录前一个元素值
        int pre = lst.get(0);
        // 记录次数
        int cnt = 1;
        // 记录最大次数
        int maxCnt = 1;
        // 记录结果
        List<Integer> res = new ArrayList<Integer>();
        res.add(lst.get(0));
        for(int i = 1; i < lst.size(); i++){
            // 如果与前一个节点的值相等
            if(pre == lst.get(i)){
                cnt += 1;
            }
            else{
                cnt = 1;
            }
            // 如果和最大次数相同，将值放入 res
            if (cnt == maxCnt){
                res.add(lst.get(i));
            }
            // 如果大于最大次数
            else if(cnt > maxCnt){
                // 更新最大次数
                maxCnt = cnt;
                // 重新更新 res
                res.clear();
                res.add(lst.get(i));
            }
            pre = lst.get(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end

