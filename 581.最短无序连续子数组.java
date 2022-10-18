import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length;
        int[] nums2 = nums.clone();//学到了个复制数组的新方法：clone()
        Arrays.sort(nums2);
        int left = 0, right = l - 1;
        //找到第一个不同的下标
        while(left <= right && nums[left] == nums2[left])
            left++;
        //找到最后一个不同的下标
        while(left <= right && nums[right] == nums2[right])
            right--;
        return right - left + 1;
    }
}
// @lc code=end

