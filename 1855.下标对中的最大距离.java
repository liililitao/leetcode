/*
 * @lc app=leetcode.cn id=1855 lang=java
 *
 * [1855] 下标对中的最大距离
 */

// @lc code=start
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0, n = nums1.length, m = nums2.length;
        for (int i = 0, j = 0; i < n && j < m; i++) {//指针i，指针j
            while (j < m && nums1[i] <= nums2[j])//对每个i，寻找j的最大位置
                j++;
            ans = Math.max(ans, j - i - 1);
        }
        return ans;
    }
}
// @lc code=end

