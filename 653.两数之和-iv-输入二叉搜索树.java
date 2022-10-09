import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
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
    //完美！双指针一遍过！！
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        //相当于一个从小到大排序的数组
        List<Integer> num = inorderTraversal(root, list);
        int left = 0, right = num.size() - 1;//左右指针
        while(left < right) {
            if(num.get(left) + num.get(right) == k)//满足条件
                return true;
            if(num.get(left) + num.get(right) < k) {
                left++;//左指针右移
            }
            if(num.get(left) + num.get(right) > k) {
                right--;//右指针左移
            }
        }
        return false;//没有符合题目要求的
    }
    //中序遍历，返回有序集合
    List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null) return list;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        return list;
    }
}
// @lc code=end

