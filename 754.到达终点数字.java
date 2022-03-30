/*
 * @lc app=leetcode.cn id=754 lang=java
 *
 * [754] 到达终点数字
 */

// @lc code=start
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0, sum = 0;
        while (sum<target || (sum-target)%2!=0) {
            step++;
            sum += step;
        }
        return step;
    }
}
// @lc code=end

