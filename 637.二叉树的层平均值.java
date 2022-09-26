import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    //嘿嘿嘿，难不倒我！！！
    public List<Double> averageOfLevels(TreeNode root) {
        //利用队列进行层次遍历，写了好多次了
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.offer(root);//根节点入队
        while(!queue.isEmpty()) {
            int l = queue.size();
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0; i < l; i++) {
                TreeNode node = queue.poll();//出队
                list2.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);//出一个进两个
                if(node.right != null)
                    queue.offer(node.right);
            }
            list.add(list2);
        }
        List<Double> res = new ArrayList<>();
        double sum = 0.0;//类型都要是double类型
        double ave = 0.0;
        for(int i = 0; i < list.size(); i++) {
            sum = 0.0;//重置sum
            for(int j = 0; j < list.get(i).size(); j++) {
                sum += list.get(i).get(j);//和
            }
            ave = sum / list.get(i).size();//平均值
            res.add(ave);
        }
        return res;
    }
}
// @lc code=end

