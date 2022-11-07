/*
 * @lc app=leetcode.cn id=2299 lang=java
 *
 * [2299] 强密码检验器 II
 */

// @lc code=start
class Solution {
    String ap = "!@#$%^&*()-+";

    public boolean strongPasswordCheckerII(String password) {
        int n = password.length();
        if (n < 8) return false;
        boolean hasMlet, hasBlet, hasDit, hasAp;
        hasMlet = hasBlet = hasDit = hasAp = false;
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (i > 0 && c == password.charAt(i - 1)) return false;
            if (Character.isDigit(c)) hasDit = true;
            else if (c >= 'a' && c <= 'z') hasMlet = true;
            else if (c >= 'A' && c <= 'Z') hasBlet = true;
            else {
                for (int j = 0; j < ap.length(); j++) {
                    if (ap.charAt(j) == c) {
                        hasAp = true;
                        break;
                    }
                }
            }
        }
        return hasMlet && hasAp && hasDit && hasBlet;
  }
}
// @lc code=end

