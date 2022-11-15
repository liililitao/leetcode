/*
 * @lc app=leetcode.cn id=1636 lang=java
 *
 * [1636] 按照频率将数组升序排序
 */

// @lc code=start
class Solution {
    public int[] frequencySort(int[] nums) {
        int[] tmp = new int[201];
        for (int n : nums)
            tmp[n + 100]++;
        for (int i = 0; i < nums.length; i++)
            nums[i] = tmp[nums[i] + 100] * 1000 - nums[i] + 100;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            nums[i] = 100 - nums[i] % 1000;
        return nums;
    }
}
// @lc code=end

