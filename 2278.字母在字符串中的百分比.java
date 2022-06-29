/*
 * @lc app=leetcode.cn id=2278 lang=java
 *
 * [2278] 字母在字符串中的百分比
 */

// @lc code=start
class Solution {
    public int percentageLetter(String s, char letter) {
        //so easy!!!
        int l = s.length(), count = 0;
        for(int i = 0; i < l; i++) {
            if(s.charAt(i) == letter)
                count++;
        }
        return 100*count / l;
    }
}
// @lc code=end

