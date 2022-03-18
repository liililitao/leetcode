/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int max = dp[0];
        //dp[i]表示以第i个元素结尾的最长递增子序列的长度
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);//求dp数组中的最大值
		}
		return max;
    }
}
// @lc code=end

