/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    //啊哈哈哈，根本难不倒我！！！
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int l = nums.length;
        for(int i = 0; i < l; i++) {
            for(int j = i + 1; j <= k + i && j < l; j++) {
                //全部强制转换为long型
                long m = Math.abs((long)nums[i] - (long)nums[j]);
                if(m <= t)
                    return true;
            }
        }
        return false;
    }
}
// @lc code=end

