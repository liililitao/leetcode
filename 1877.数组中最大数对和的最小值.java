import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1877 lang=java
 *
 * [1877] 数组中最大数对和的最小值
 */

// @lc code=start
class Solution {
    public int minPairSum(int[] nums) {
        //天呐，这题太简单了吧，秒杀加一遍过！
        int l = nums.length, max = 0;
        Arrays.sort(nums);
        for(int i = 0; i < l/2; i++) {
            max = Math.max(max, nums[i] + nums[l - 1 - i]);
        }
        return max;
    }
}
// @lc code=end

