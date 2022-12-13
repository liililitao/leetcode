/*
 * @lc app=leetcode.cn id=1827 lang=java
 *
 * [1827] 最少操作使数组递增
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        //啊哈哈哈！！！so easy啦！！！
        int l = nums.length;
        if(l < 2) return 0;
        int count = 0;
        for(int i = 0; i < l - 1; i++) {
            if(nums[i + 1] <= nums[i]) {
                count += (nums[i] - nums[i + 1] + 1);
                nums[i + 1] = (nums[i] + 1);
            }
        }
        return count;
    }
}
// @lc code=end

