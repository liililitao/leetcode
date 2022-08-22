/*
 * @lc app=leetcode.cn id=1679 lang=java
 *
 * [1679] K 和数对的最大数目
 */

// @lc code=start
class Solution {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        //排序
        Arrays.sort(nums);
        //头尾指针
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (k == sum) {//刚好相等。两个指针都往中间移动
                result++;
                i++;
                j--;
            } else if (k > sum) {//两数之和太小，左指针右移，让和变大
                i++;
            } else {//两数之和太大，右指针左移，让和变小
                j--;
            }
        }
        return result;
    }
}
// @lc code=end