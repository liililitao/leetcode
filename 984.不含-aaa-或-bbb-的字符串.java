/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int A, int B) {
        char[] str = new char[A + B];
        char c1 = 'a', c2 = 'b';
        if (A < B) {
            c1 = 'b';
            c2 = 'a';
            int in = A;
            A = B;
            B = in;
        }
        Arrays.fill(str, c1);
        for (int i = 2; i < str.length; i += 3) {
            if (B > 0) {
                str[i] = c2;
                B--;
            }
        }
        // 如果第一遍填写B用完了，则直接返回答案
        if (B == 0) {
            return new String(str);
        }
        for (int i = 1; i < str.length; i += 3) {
            if (B > 0) {
                str[i] = c2;
                B--;
            }
        }
        return new String(str);
    }
}
// @lc code=end

