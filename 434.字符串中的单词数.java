/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        boolean flag = false;	// 遇到非空格字符后此标志位置true，否则置false
        int count = 0;	// 单词计数器
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) != ' ') {	// 如果遇到非空格字符，flag置true
                flag = true;
            }
            // 在flag为true的基础上，再次遇到空格字符或已经是字符串末尾，计数器count+1
            if(flag && (s.charAt(i) == ' ' || i == s.length() - 1)) {
                ++count;
                flag = false;
            }
        }
        return count;
    }
}
// @lc code=end

