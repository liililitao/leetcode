/*
 * @lc app=leetcode.cn id=1015 lang=java
 *
 * [1015] 可被 K 整除的最小整数
 */

// @lc code=start
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int len = 1, num = 1;
        while(num % k != 0) {
            num = num*10+1;
            num %= k;
            len++;
        }
        return len;
    }
}
// @lc code=end

