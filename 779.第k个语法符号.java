/*
 * @lc app=leetcode.cn id=779 lang=java
 *
 * [779] 第K个语法符号
 */

// @lc code=start
class Solution {
    public int kthGrammar(int n, int k) {
        //k-1转化为二进制中1的个数对2求余
        return Integer.bitCount(k - 1) % 2;
    }
}
// @lc code=end

