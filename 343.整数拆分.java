/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a = 1;
        while (n > 4) {//尽可能的选用3，这样可以保证最后乘积最大
            n = n - 3;//每次减3
            a = a * 3;//乘3，计算乘积
        }
        //最后n=4，3，2都可以，和a乘就行了，结果肯定是最大的
        return a * n;
    }
}
// @lc code=end

