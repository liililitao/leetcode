import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
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
    //啊哈哈，我太厉害了！！！
    public int maxLevelSum(TreeNode root) {
        //利用队列进行层次遍历
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        queue.offer(root);//根节点入队
        while(!queue.isEmpty()) {
            int l = queue.size();//上一层的节点个数
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < l; i++) {
                TreeNode node = queue.poll();//出队一个
                list.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);//入队两个
                if(node.right != null)
                    queue.offer(node.right);
            }
            res.add(list);//一层
        }
        int n = res.size();
        int[] sum = new int[n];//储存每一层的元素之和
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < res.get(i).size(); j++) {
                sum[i] += res.get(i).get(j);
            }
        }
        int max = Integer.MIN_VALUE, result = 0;
        for(int i = 0; i < n; i++) {
            if(sum[i] > max) {//这里不能 = ，因为题目中要求返回最大的那几层中层号最小的那个
                max = sum[i];
                result = i;//这是索引，最后还要加1
            }
        }
        return result + 1;
    }
}
// @lc code=end

