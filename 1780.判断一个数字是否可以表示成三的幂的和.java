/*
 * @lc app=leetcode.cn id=1780 lang=java
 *
 * [1780] 判断一个数字是否可以表示成三的幂的和
 */

// @lc code=start
class Solution {
    public boolean checkPowersOfThree(int n) {
        //如果一个数字可以表示成三的幂的和，那么这个数字转换为三进制后，数字应该只有0和1
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
// @lc code=end

