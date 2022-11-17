/*
 * @lc app=leetcode.cn id=1576 lang=java
 *
 * [1576] 替换所有的问号
 */

// @lc code=start
class Solution {
    public String modifyString(String s) {
        if (s.length() == 1) {
            if (s.equals("?")) return "a";
            return s;
        }
        char[] ch = s.toCharArray();
        //替代?的字符
        char c = 'a';
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '?') {
                //不是起始位也不是结束位
                if (i > 0 && i < ch.length - 1) {
                    while (ch[i-1] == c || ch[i+1] == c) c++;
                    //替换
                    ch[i] = c;
                    //c重置
                    c = 'a';
                }
                //起始位
                else if (i == 0) {
                    if (ch[i+1] == c) c++;
                    ch[i] = c;
                    c = 'a';
                }
                //结束位
                else {
                    if (ch[i-1] == c) c++;
                    ch[i] = c;
                    c = 'a';
                }
            }
        }
        return new String(ch);
    }
}
// @lc code=end

