import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.naming.LinkLoopException;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    //在层次遍历的过程中直接找每一层的最大值
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        //用队列层次遍历，代码写了好多次了
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while(!queue.isEmpty()) {
            int l = queue.size();
            max = Integer.MIN_VALUE;//max初值赋为最小
            for(int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);//更新最大值
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            res.add(max);//添加到结果列表中
        }
        return res;
    }
}
// @lc code=end

