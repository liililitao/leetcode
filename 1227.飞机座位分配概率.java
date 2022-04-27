/*
 * @lc app=leetcode.cn id=1227 lang=java
 *
 * [1227] 飞机座位分配概率
 */

// @lc code=start
class Solution {
    public double nthPersonGetsNthSeat(int n) {
        //纯数学问题
        if(n == 1) return 1;
        return 0.5;
    }
}
// @lc code=end

