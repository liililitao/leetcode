/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int s[] = new int[n + 1];
        for (int i = 1; i <= n; i ++ ) {
            //0换成-1
            if (nums[i - 1] == 0) {
                nums[i - 1] = -1;
            }
            s[i] = s[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        //前缀和是1开始的，这里初始化边界问题
        map.put(0, 0);
        for (int i = 1; i <= n; i ++ ) {
            if (map.containsKey(s[i])) {
                res = Math.max(res, i - map.get(s[i]));
            } else {
                map.put(s[i], i);
            }
        }       
        return res;
    }
}
// @lc code=end

