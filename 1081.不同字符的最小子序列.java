import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1081 lang=java
 *
 * [1081] 不同字符的最小子序列
 */

// @lc code=start
class Solution {
    public String smallestSubsequence(String s) {
        String res = "";
        boolean inRes[] = new boolean[26]; //是否在答案中出现过
        int lastPos[] = new int[26]; //最后出现的位置
        int n = s.length();
        for (int i = 0; i < n; i ++ ) {
            lastPos[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < n; i ++ ) {
            char c = s.charAt(i);
            if (inRes[c - 'a']) continue;
            while (!"".equals(res) && res.charAt(res.length() - 1) > c && lastPos[res.charAt(res.length() - 1) - 'a'] > i) {
                //标记为没出现过
               inRes[res.charAt(res.length() - 1) - 'a'] = false;
               //去掉最后一位字符
            res = res.substring(0, res.length() - 1);
            }
            //加入新的字符，并且标记为出现过
            res += c;
            inRes[c - 'a'] = true;
        }
        return res;
    }
}
// @lc code=end

