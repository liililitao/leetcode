/*
 * @lc app=leetcode.cn id=1551 lang=java
 *
 * [1551] 使数组中所有元素相等的最小操作数
 */

// @lc code=start
class Solution {
    public int minOperations(int n) {
        //一个很简单的数学问题
        int s = 0;
        for(int i = 1; i < n; i += 2) {
            s += i;
        }
        return n*(n/2) - s;
    }
}
// @lc code=end

