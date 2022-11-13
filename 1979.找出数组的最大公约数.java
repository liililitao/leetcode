import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1979 lang=java
 *
 * [1979] 找出数组的最大公约数
 */

// @lc code=start
class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        int min = nums[0], max = nums[l - 1];
        for(int i = min; i > 0; i--) {
            if(min % i == 0 && max % i == 0)
                return i;
        }
        return 1;
    }
}
// @lc code=end

