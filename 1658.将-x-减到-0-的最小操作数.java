/*
 * @lc app=leetcode.cn id=1658 lang=java
 *
 * [1658] 将 x 减到 0 的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[len + 1];
        map.put(0, 0);
        int temp = 0;
        for (int i = 1; i <= len; i++) {
            map.put(temp = sum[i - 1] + nums[i - 1], i);
            sum[i] = temp;
        }
        int target = sum[len] - x;
        if (target < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = len; i > 0 && sum[i] >= target; i--) {
            if (map.containsKey(temp = sum[i] - target)) {
                res = Math.min(res, len - i + map.get(temp));
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
// @lc code=end

