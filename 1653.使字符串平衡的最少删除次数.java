/*
 * @lc app=leetcode.cn id=1653 lang=java
 *
 * [1653] 使字符串平衡的最少删除次数
 */

// @lc code=start
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int ans = 0, res = 0;
        int left = 0;
        for(left = 0; left < n; left++) {   // 左边一直是a
            if(s.charAt(left) != 'a') {
                break;
            }
        }
        for(int i = left; i < n; i++) {
            if(s.charAt(i) == 'a') {   // 出现a的个数
                ans++;
            } else {       // 开始出现b的个数
                res++;
            }
            if(ans > res) {    // 如果要删除的a的个数大于删除b的个数，那么删除b
                ans = res;
            }
        }
        return Math.min(ans, res);  // a 和 b 哪个少删除哪个
    }
}
// @lc code=end

