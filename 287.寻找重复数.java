import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 1; i <= n; i++) {
            if(nums[i - 1] == nums[i])
                return nums[i - 1];
        }
        return 0;
    }
}
// @lc code=end

