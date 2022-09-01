import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    //层序遍历很简单，利用队列就可以，关键是如何把每一层都分开
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;
        queue.offer(root);//入队
        while(!queue.isEmpty()) {//当队列非空
            int l = queue.size();//上一层的节点个数
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0; i < l; i++) {//上一层
                TreeNode node = queue.poll();//出队
                list2.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);//左子树入队
                if(node.right != null)
                    queue.offer(node.right);//右子树入队
            }
            list.add(list2);//把这一层添加进来
        }
        return list;
    }
}
// @lc code=end

