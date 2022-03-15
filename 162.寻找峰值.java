/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int l = nums.length;
        if(l == 1) return 0;//只有一个元素，那它自己就是峰值
        for(int i = 1; i < l - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;//符合条件，直接返回就行
        }
        //没有符合条件的，说明数组是一个有序数组，要么从大到小排，要么从小到大排
        if(nums[0] > nums[l - 1]) //从大到小排
            return 0;//返回峰值的索引0
        else //从小到大排
            return l - 1;//返回峰值的索引l-1
    }
}
// @lc code=end

