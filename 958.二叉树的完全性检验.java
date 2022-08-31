/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
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
    //二叉树的层次遍历：利用队列
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            //当发现队列中有空节点时 遍历队列剩下的元素 若出现非空节点 则不是完全二叉树
            if(node == null){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    if(queue.poll() != null){
                        return false;
                    }
                }
                return true;//全部遍历完没有非空节点，则就是完全二叉树
            }
            queue.offer(node.left);//左子树入队
            queue.offer(node.right);//右子树入队
        }
        return true;
    }
}
// @lc code=end

