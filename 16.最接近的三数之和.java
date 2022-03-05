/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //和上一题思路一样
        Arrays.sort(nums);
        int res = 10000;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;//左指针
            int right = nums.length - 1;//右指针
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) 
                    return sum;
                if (Math.abs(sum - target) < Math.abs(res - target)) 
                    res = sum;//找最接近target的
                if (sum < target) //和小于目标值，左指针右移
                    left++;
                else //和大于目标值，右指针左移
                    right--;
            }
        }
        return res;
    }
}
// @lc code=end

