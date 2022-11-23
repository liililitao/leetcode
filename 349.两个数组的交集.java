/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        int[] ans = new int[set.size()];
        int ind = 0;
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i]))  {
                ans[ind ++] = nums2[i];
                set.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(ans, 0, ind);
    }
}
// @lc code=end

