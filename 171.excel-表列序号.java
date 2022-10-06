/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    //太简单了呀，秒杀！其实就是26进制转十进制
    public int titleToNumber(String columnTitle) {
        int l = columnTitle.length();
        int res = 0, k = l - 1;
        for(int i = 0; i < l; i++) {//大写'A'的ASCII码为65，所以要减64
            res += (int)(columnTitle.charAt(i) - 64) * Math.pow(26, k);
            k--;
        }
        return res;
    }
}
// @lc code=end

