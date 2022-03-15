/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        //因为有可能k比l大，所以后面都要求余
        int l = nums.length;
        if(l == 1) return;//长度为1，不管轮转多少个位置都不变
        int[] nums2 = new int[l];//轮转后的数组
        for(int i = k%l; i < l; i++) {//填后面l-k%l个元素
            nums2[i] = nums[i - k%l];
        }
        for(int i = 0; i < k%l; i++) {//填前面k%l个元素
            nums2[i] = nums[i + (l - k%l)];
        }
        for(int i = 0; i < l; i++)
            nums[i] = nums2[i];
    }
}
// @lc code=end

