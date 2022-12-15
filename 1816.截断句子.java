/*
 * @lc app=leetcode.cn id=1816 lang=java
 *
 * [1816] 截断句子
 */

// @lc code=start
class Solution {
    public String truncateSentence(String s, int k) {
        //这个substring厉害啊！
        //s.substring 方法(0, i) 指的是返回 s 从 0 开始的，长度为 i 的字符串。
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                k--;
                if(k == 0) return s.substring(0, i);
            }
        }
        return s;
    }
}
// @lc code=end

