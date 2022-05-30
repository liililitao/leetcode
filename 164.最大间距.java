import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        //不是，这也算hard题？秒杀了，比easy题还easy
        int l = nums.length;
        if(l < 2) return 0;
        Arrays.sort(nums);
        int max = 0;
        for(int i = 1; i < l; i++)
            max = Math.max(max, nums[i] - nums[i - 1]);
        return max;
    }
}
// @lc code=end

