/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    //和上题一样，把list翻转一下就可以
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
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
        for(int i = list.size() - 1; i >= 0; i--)//翻转list得到最终结果
            res.add(list.get(i));
        return res;
    }
}
// @lc code=end

