/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target)return i;
        }
        return -1;
    }
}
// @lc code=end

