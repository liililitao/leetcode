/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int l = s.length();
        if(l <= 1) return s;//只有一个字符肯定是回文串
        int start = 0, end = 0;
        for(int i = 0; i < l; i++) {
            int len1 = expandAroundCenter(s, i, i);//长度为奇数的回文串的长度
            int len2 = expandAroundCenter(s, i, i + 1);//长度为偶数的回文串的长度
            int len = Math.max(len1, len2);//取最大值
            if(len > end - start) {
                start = i - (len - 1) / 2;//记录最长回文子串的起始位置
                end = i + len / 2;//记录最长回文子串的末位置
            }
        }
        return s.substring(start, end + 1);
    }
    
    public int expandAroundCenter(String s, int left, int right) {
        //从中心开始依次往两边判断是否是回文串
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;//返回以这次的i为中心的最长回文串的长度
    }
}
// @lc code=end

