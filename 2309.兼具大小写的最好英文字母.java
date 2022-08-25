/*
 * @lc app=leetcode.cn id=2309 lang=java
 *
 * [2309] 兼具大小写的最好英文字母
 */

// @lc code=start
class Solution {
    //既然要找最“好”的英文字母，那么从'Z'开始往前遍历就好了
    public String greatestLetter(String s) {
        for(char x = 'Z'; x >= 'A'; x--) {
            if(s.contains(String.valueOf(x)) && s.contains(String.valueOf(x).toLowerCase()))
                return String.valueOf(x);//字符转字符串
        }
        return "";
    }
}
// @lc code=end

