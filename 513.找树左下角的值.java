import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    //利用层次遍历，找到最后一层的第一个值，即为树左下角的值
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);//根节点入队
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            int l = queue.size();//上一层的节点个数
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0; i < l; i++) {//上一层
                TreeNode node = queue.poll();//出队
                list2.add(node.val);//层次遍历的要点：出一个进两个，出一个进两个
                if(node.left != null)
                    queue.offer(node.left);//左子树入队
                if(node.right != null)
                    queue.offer(node.right);//右子树入队
            }
            res.add(list2);//把这一层添加进来
        }
        int k = res.size() - 1;//最后一层
        return res.get(k).get(0);
    }
}
// @lc code=end

