/*
 * @lc app=leetcode.cn id=1578 lang=java
 *
 * [1578] 使绳子变成彩色的最短时间
 */

// @lc code=start
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i = 0, len = colors.length();
        int ret = 0;
        while (i < len) {
            char ch = colors.charAt(i);
            int maxValue = 0;
            int sum = 0;//每次都要重置为0
            //将连续出现的最大值记录下来，把它保留，其余的全部移除
            while (i < len && colors.charAt(i) == ch) {
                maxValue = Math.max(maxValue, neededTime[i]);
                sum += neededTime[i];//连续出现的全部加起来
                i++;
            }
            ret += sum - maxValue;//加上总和减去最大值
        }
        return ret;
    }
}
// @lc code=end

