/*
 * @lc app=leetcode.cn id=2315 lang=java
 *
 * [2315] 统计星号
 */

// @lc code=start
class Solution {
    //太简单了！！！
    public int countAsterisks(String s) {
        int l = s.length(), count = 0;
        boolean flag = true;//标志
        for(int i = 0; i < l; i++) {
            if(s.charAt(i) == '|')
                flag = !flag;//每遇到一个'|'反转一次
            if(s.charAt(i) == '*') {
                if(flag == true)//不在竖线对之间
                    count++;
            }
        }
        return count;
    }
}
// @lc code=end

