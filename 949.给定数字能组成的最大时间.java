import java.util.Arrays;

import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode.cn id=949 lang=java
 *
 * [949] 给定数字能组成的最大时间
 */

// @lc code=start
class Solution {
    public String largestTimeFromDigits(int[] A) {
    int ans = -1;
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 4; ++j) {
            for (int k = 0; k < 4; ++k) {
                if (i == j || j == k || i == k) {
                    continue;
                }
                int hours = 10 * A[i] + A[j];
                int mins = 10 * A[k] + A[6 - i - j - k];
                if (hours < 24 && mins < 60) {
                    ans = Math.max(ans, hours * 60 + mins);
                }
            }
        }
    }
    return ans == -1 ? "" : String.format("%02d:%02d", ans/60, ans%60);
    }
}
// @lc code=end

