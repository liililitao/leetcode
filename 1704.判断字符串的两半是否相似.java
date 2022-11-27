/*
 * @lc app=leetcode.cn id=1704 lang=java
 *
 * [1704] 判断字符串的两半是否相似
 */

// @lc code=start
class Solution {
    public boolean halvesAreAlike(String s) {
        //太无聊！！！
        int sum1 = 0, sum2 = 0, l = s.length();
        for(int i = 0; i < l / 2; i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                sum1++;
            }
        }
        for(int i = l/2; i < l; i++) {
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                sum2++;
            }
        }
        if(sum1 == sum2) {
            return true;
        }
        return false;
    }
}
// @lc code=end

