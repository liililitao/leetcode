/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        int l = str.length;
        if(pattern.length() != l) return false;//长度不相等，直接false
        for(int i = 0; i < l - 1; i++) {
            for(int j = i + 1; j < l; j++) {
                if(pattern.charAt(i) == pattern.charAt(j)) {
                    if(!str[i].equals(str[j]))
                        return false;
                }
                else {
                    if(str[i].equals(str[j]))
                        return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

