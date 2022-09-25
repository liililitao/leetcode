import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1305 lang=java
 *
 * [1305] 两棵二叉搜索树中的所有元素
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
    //这太简单了呀，不就是遍历加排序！！！
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res = traverse(root1, list);//遍历第一棵树
        res = traverse(root2, list);//遍历第二棵树
        Collections.sort(res);//排序
        return res;
    }
    //先序遍历：根左右
    List<Integer> traverse(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        list.add(root.val);//添加节点值
        traverse(root.left, list);//遍历左子树
        traverse(root.right, list);//遍历右子树
        return list;
    }
}
// @lc code=end

