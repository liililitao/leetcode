/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    //枚举法
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

