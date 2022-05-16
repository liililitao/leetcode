/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        /**
         * 如果m和n不相等，那么[m, n]范围内一定既包含奇数也包含偶数
        既然[m, n]范围内既包含奇数也包含偶数，
        那么其末位与的结果一定是0。
         */
        if(left == 0){
            return 0;
        }
        int temp = 1;
        while(left != right){
            left >>= 1;//右移一位
            right >>= 1;//右移一位
            temp <<= 1;//左移一位
        }
        return left * temp;
    }
}
// @lc code=end

