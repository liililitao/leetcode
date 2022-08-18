/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    //动态规划
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) //只有一个房屋，偷就行了
            return nums[0];
        int[] dp = new int[length];//dp[i] 表示前 i 间房屋能偷窃到的最高总金额
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {//核心代码：在第 i 间 偷与不偷 选最大的
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
// @lc code=end

